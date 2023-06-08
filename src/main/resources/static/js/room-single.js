//function init(){
//    // Add submit event to form for new and edit
//    $("#booking-form").on('submit', function() {
//        console.log("Submitting");
//    });
//}

//
//$(document).ready(function() {
//  var roomItems = $('#roomItems');
//  var storedRooms = localStorage.getItem('rooms');
//  var inDate = localStorage.getItem('inDate');
//  var outDate = localStorage.getItem('outDate');
//  var adult = localStorage.getItem('adult');
//  var children = localStorage.getItem('children');
//  var smoking = localStorage.getItem('smoking');;
//  var disabled = localStorage.getItem('disabled');
//  console.log(inDate, outDate, adult, children, smoking, disabled);
//
//  $('#inDate').val(inDate);
//  $('#outDate').val(outDate);
//  $('#adult').val(adult);
//  $('#children').val(children);
//  $('#smoking').val(smoking === "true" ? "Smoking" : "Non smoking");
//  $('#disabled').val(disabled === "true" ? "Disabled" : "Non disabled" );
//
// var addedRoomTypes = []; // Track the room types that have been added
//  var isFirstRoomAdded = false; // Flag to track if the first room has been added
//
//  if (storedRooms) {
//    var rooms = JSON.parse(storedRooms);
//
//    // Sort the rooms array by price in ascending order
//    rooms.sort(function(a, b) {
//      return a.price - b.price;
//    });
//
//    if (rooms.length > 0) {
//      rooms.forEach(function(room) {
//        var roomType = room.typeOfRoom;
//
//        // Check if the room type is 'Single' and the first room has not been added
//        if (roomType === 'Single' && !isFirstRoomAdded) {
//          addedRoomTypes.push(roomType); // Add the room type to the array
//
//
//          // Rest of the code for creating the room item element
////          var imagePath = room.imageLink;
////          var roomName = room.typeOfRoom;
//          var inDate = room.checkInDate;
//          var roomPrice = room.price;
//          var maxCapacity = room.capacityOfGuests;
//          var bedType = room.typeOfBed;
//          var special = room.smoking ? "Yes" : "No";
//          var amenities = room.facilities;
////          var roomLink = getRoomLink(roomName);
//
//
//  var roomItem = $('<h2><span>from </span>' + roomPrice + '<span>/Per night</span></h2>\
//                              <table>\
//                                  <tbody>\
//                                  <tr>\
//                                      <td class="r-o">Capacity:</td>\
//                                      <td>Max persion ' + maxCapacity + '</td>\
//                                  </tr>\
//                                  <tr>\
//                                      <td class="r-o">Bed:</td>\
//                                      <td>' + bedType + '</td>\
//                                  </tr>\
//                                  <tr>\
//                                      <td class="r-o">Services:</td>\
//                                      <td>' + amenities + '</td>\
//                                  </tr>\
//                                  </tbody>\
//                              </table>\
//                             ');
//          roomItems.append(roomItem);
//           isFirstRoomAdded = true;
//        }
//      });
//    } else {
//      roomItems.html('<p>No rooms found.</p>');
//    }
//    localStorage.removeItem('rooms');
//  } else {
//    roomItems.html('<p>No rooms found.</p>');
//  }
//});




function init() {
  // Добавляем событие submit для формы создания и редактирования
  $("#booking-form").on('submit', function() {
    console.log("Submitting");
  });
}

$(document).ready(function() {
  var roomItems = $('#roomItems');
  var storedRooms = localStorage.getItem('rooms');
  var inDate = localStorage.getItem('inDate');
  var outDate = localStorage.getItem('outDate');
  var adult = localStorage.getItem('adult');
  var children = localStorage.getItem('children');
  var smoking = localStorage.getItem('smoking');
  var disabled = localStorage.getItem('disabled');
  console.log(inDate, outDate, adult, children, smoking, disabled);

  $('#inDate').val(inDate);
  $('#outDate').val(outDate);
  $('#adult').val(adult);
  $('#children').val(children);
  $('#smoking').val(smoking === "true" ? "Smoking" : "Non smoking");
  $('#disabled').val(disabled === "true" ? "Disabled" : "Non disabled");

  var addedRoomTypes = []; // Отслеживаем добавленные типы комнат
  var isFirstRoomAdded = false; // Флаг для отслеживания добавления первой комнаты

  if (storedRooms) {
    var rooms = JSON.parse(storedRooms);

    // Сортируем массив комнат по цене в порядке возрастания
    rooms.sort(function(a, b) {
      return a.price - b.price;
    });

    if (rooms.length > 0) {
      rooms.forEach(function(room) {
        var roomType = room.typeOfRoom;

        // Проверяем, если тип комнаты 'Single' и первая комната еще не добавлена
        if (roomType === 'Single' && !isFirstRoomAdded) {
          addedRoomTypes.push(roomType); // Добавляем тип комнаты в массив

//          var inDate = room.checkInDate;
//          var outDate = room.checkOutDate;
          var roomPrice = room.price;
          var adult = room.capacityOfAdults;
          var children = room.capacityOfChildren;
          var bedType = room.typeOfBed;
          var smoking = room.smoking ? "Yes" : "No";
          var disabled = room.disabled ? "Yes" : "No";
          var amenities = room.facilities;
console.log(inDate);
console.log(outDate);
          // Создаем выпадающее меню для услуг с горизонтальным текстом
          var selectMenu = '<select id="servicesSelect" style="width: 500px;">' +
                           '<option style="writing-mode: horizontal;">' + amenities + '</option>' +
                           '</select>';

          var roomItem = $('<h2><span>Price: </span>' + roomPrice + '$<span>/Per night</span></h2>\
                              <table>\
                                  <tbody>\
                                 <tr>\
                                      <td class="r-o">Adult:</td>\
                                      <td> ' + adult + ' </td>\
                                  </tr>\
                                   <tr>\
                                      <td class="r-o">Children:</td>\
                                      <td> ' + children + ' </td>\
                                  </tr>\
                                  <tr>\
                                      <td class="r-o">Bed type:</td>\
                                      <td>' + bedType + '</td>\
                                  </tr>\
                                  <tr>\
                                      <td class="r-o">Smoking:</td>\
                                      <td>' + smoking + '</td>\
                                  </tr>\  <tr>\
                                      <td class="r-o">Disabled:</td>\
                                      <td>' + disabled + '</td>\
                                  </tr>\
                                  <tr>\
                                      <td class="r-o">Facilities:</td>\
                                      <td>' + selectMenu + '</td>\
                                  </tr>\
                                  </tbody>\
                              </table>\
                             ');

          roomItems.append(roomItem);

          // Обновляем цену комнаты при выборе значения в выпадающем меню
          $('#servicesSelect').on('change', function() {
            var selectedService = $(this).val();
            $('#roomPrice').text(selectedService);
          });

          isFirstRoomAdded = true;
        }
      });
    } else {
      roomItems.html('<p>Комнаты не найдены.</p>');
    }
//    localStorage.removeItem('rooms');
  } else {
    roomItems.html('<p>Комнаты не найдены.</p>');
  }
});



        // Обработчик события submit для формы
        // The submit event handler for the form
        document.getElementById("booking-form").addEventListener("submit", function(event) {
            event.preventDefault(); // Cancel the default form submission // Отменяем отправку формы по умолчанию


            // Getting values from input fields // Получение значений из полей ввода
            var nameInput = document.getElementById("inDate");
            var nameInput = document.getElementById("outDate");
            var nameInput = document.getElementById("name");
            var surnameInput = document.getElementById("surname");
            var emailInput = document.getElementById("email");
            var phoneInput = document.getElementById("phone");

            var inDateValue = inDate.value;
            var outDateValue = outDate.value;
            var nameValue = nameInput.value;
            var surnameValue = surnameInput.value;
            var emailValue = emailInput.value;
            var phoneValue = phoneInput.value;

            // print to console
            console.log("inDate: " + inDateValue);
            console.log("outDate: " + outDateValue);
            console.log("Name: " + nameValue);
            console.log("Surname: " + surnameValue);
            console.log("Email: " + emailValue);
            console.log("Phone number: " + phoneValue);

            //Additional actions, such as sending data to the server
            // Дополнительные действия, например, отправка данных на сервер
        });
