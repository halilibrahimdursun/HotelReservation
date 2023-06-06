
///-----------------------script for button of the booking form ------------

function init(){
    // Add submit event to form for new and edit
    $("#booking-form").on('submit', function() {
    console.log("Submitting");
    });
}

///-----------------------END script for button of the booking form ------------


///-----------------------script for getting information from booking form ------------

$(document).ready(function() {
  $("#booking-form").on('submit', function(event) {
    event.preventDefault(); // Page Reload Prevention // Предотвращение перезагрузки страницы

    // Getting form field values // Получение значений полей формы
     var checkInDate = $("#date-in").val();
     var checkOutDate = $("#date-out").val();
     var capacityOfAdults = $("#adult").val();
     var capacityOfChildren = $("#children").val();

     var smokingValue = $("#smoking").val();
     var smoking = (smokingValue === "0") ? false : true;

     var disabledValue = $("#disabled").val();
     var disabled = (disabledValue === "0") ? false : true;

     var cleaned = true;



    // Create an object with form data / Создание объекта с данными формы

//
    var formData = {
//      checkInDate: checkInDate,
//      checkOutDate: checkOutDate,
      capacityOfAdults: capacityOfAdults,
      capacityOfChildren: capacityOfChildren,
      smoking: smoking,
      disabled: disabled,
      cleaned: cleaned
//      // Add the rest of the formData object properties based on the form fields
//      //Добавьте остальные свойства объекта formData на основе полей формы
    };

// Performing More Actions on Form Data
    console.log("Form submitted");
    console.log("Check-in date: " + checkInDate);
    console.log("Check-out date: " + checkOutDate);
    console.log("Selected Adult: " + capacityOfAdults);
    console.log("Children count: " + capacityOfChildren);
    console.log("Smoking: " + smoking);
    console.log("Disabled: " + disabled);
    console.log("Cleaned: " + cleaned);

    var criteria =JSON.stringify(formData);


    // Sending an AJAX request to the server // Отправка AJAX-запроса на сервер
 $.ajax({
   url: '/api/room/available?checkInDate=' + checkInDate + '&checkOutDate=' + checkOutDate,
   type: 'POST',
   contentType: 'application/json', // Add this line // Добавьте эту строку
    data: criteria, // Convert formData object to JSON format // Преобразуйте объект formData в формат JSON
   success: function(response) {
console.log(response);
localStorage.setItem('rooms', JSON.stringify(response));
window.location.href = 'rooms.html';


//
//                var rooms = response;
//                var roomItems = $('#roomItems');
//                    roomItems.empty();
//
//                if (rooms.length > 0) {
//                    rooms.forEach(function(room) {
//                        var imagePath = room.imageLink;
//                        var roomName = room.typeOfRoom;
//                        var roomPrice = room.price;
//                        var maxCapacity = room.capacityOfGuests;
//                        var bedType = room.typeOfBed;
//                        var special = room.disabled;
//                        var amenities = room.facilities;
//
//                        var roomItem = $('<div class="col-lg-4 col-md-6">\
//                            <div class="room-item">\
//                            <form class="my-form">\
//                               <img src="' + imagePath + '" alt="">\
//                                <div class="ri-text">\
//                                    <h4>' + roomName + '</h4>\
//                                    <h3>' + roomPrice + '$<span>/Pernight</span></h3>\
//                                    <table>\
//                                        <tbody>\
//                                            <tr>\
//                                                <td class="r-o">Capacity:</td>\
//                                                <td>Max person ' + maxCapacity + '</td>\
//                                            </tr>\
//                                            <tr>\
//                                                <td class="r-o">Bed:</td>\
//                                                <td>' + bedType + '</td>\
//                                            </tr>\
//                                            <tr>\
//                                                <td class="r-o">Special:</td>\
//                                                <td>' + special + '</td>\
//                                            </tr>\
//                                            <tr>\
//                                                <td class="r-o">Services:</td>\
//                                                <td>' + amenities + '</td>\
//                                            </tr>\
//                                        </tbody>\
//                                    </table>\
//                                    <a href="./room-single.html" class="primary-btn">More Details</a>\
//                                </div>\
//                            </div>\
//                            </form>\
//                        </div>');
//
//                        roomItems.append(roomItem);
//                        console.log("test2");
//                    });
//                } else {
//                    roomItems.html('<p>No rooms found.</p>');
//                }
//

   },


   error: function(xhr, status, error) {
     console.log(status);
   }
 });

  });
});


///-----------------------END script for getting information from booking form ------------
