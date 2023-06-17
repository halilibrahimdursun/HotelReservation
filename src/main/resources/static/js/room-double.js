
$(document).ready(function() {

  var roomItems = $('#roomItems');
  var storedRooms = localStorage.getItem('rooms');
  var inDate = localStorage.getItem('inDate');
  var outDate = localStorage.getItem('outDate');
  var adult = localStorage.getItem('adult');
  var children = localStorage.getItem('children');
  var smoking = localStorage.getItem('smoking');
  var disabled = localStorage.getItem('disabled');

  console.log(inDate, outDate, adult, children, disabled);

  $('#inDate').val(inDate);
  $('#outDate').val(outDate);
  $('#adult').val(adult);
  $('#children').val(children);
  $('#smoking').val(smoking === "true" ? "Smoking" : "Non smoking");
  $('#disabled').val(disabled === "true" ? "Disabled" : "Non disabled");

  var addedRoomTypes = []; // Keeping track of added room types
  var isFirstRoomAdded = false; // Flag to keep track of adding the first room

  if (storedRooms) {
    var rooms = JSON.parse(storedRooms);

    // Sort the array of rooms by price in ascending order
    rooms.sort(function(a, b) {
      return a.price - b.price;
    });

    if (rooms.length > 0) {
      rooms.forEach(function(room) {
        var roomType = room.typeOfRoom;

        // Check if the room type is 'Single' and the first room has not been added yet
        if (roomType === 'Double' && !isFirstRoomAdded) {
          addedRoomTypes.push(roomType); // Add room type to array

          var roomPrice = room.price;
          var adult = room.capacityOfAdults;
          var children = room.capacityOfChildren;
          var bedType = room.typeOfBed;
          var smoking = room.smoking ? "Yes" : "No";
          var disabled = room.disabled ? "Yes" : "No";
          var amenities = room.facilities;
          var roomNumber = room.roomNumber;

//          var formData = {
//                roomNumber: roomNumber
//              };
//          var roomNumber =JSON.stringify(formData);
//            $.ajax({
//                      url: '/api/totallyPrice?checkInDate=' + inDate + '&checkOutDate=' + outDate,
//                      type: 'PUT',
//                      contentType: 'application/json',
//                      data: JSON.stringify({roomNumber:roomNumber}),
//                      success: function(response) {
//                        console.log(response);
//                  localStorage.setItem('totalPrice', response);
//
//
//                      },
//                      error: function(xhr, status, error) {
//                        console.log(status);
//                      }
//                    });

// count totalPrice
var checkInDate = new Date(inDate);
var checkOutDate = new Date(outDate);
var daysBetween = Math.ceil((checkOutDate - checkInDate) / (1000 * 60 * 60 * 24)); // Calculate the number of days
var totalPrice = roomPrice * daysBetween;


//          var totalPrice = localStorage.getItem('totalPrice');
          var roomItem = $('<h2><span>Total price:  </span>' + totalPrice + '$<span></span></h2>\
                              <table>\
                                  <tbody>\
                                  <tr>\
                                        <td class="r-o">Room number:</td>\
                                        <td> ' + roomNumber + ' </td>\
                                 </tr>\
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
                                      <td>' + amenities + '</td>\
                                  </tr>\
                                  </tbody>\
                              </table>\
                             ');

          roomItems.append(roomItem);

          // Применить язык к новой форме. Запускаем перевод после создания каждой формы
                    applyLanguage(selectedLanguage);

          // Store roomNumber in a hidden input field
          var roomNumberInput = $('<input type="hidden" name="roomNumber" value="' + roomNumber + '">');
          roomItem.append(roomNumberInput);

          isFirstRoomAdded = true;
        }
      });
    } else {
      roomItems.html('<p>No rooms found.</p>');
    }
  } else {
    roomItems.html('<p>No rooms found.</p>');
  }
});


//--------------------- Обработчик события submit для формы----------------------------//
/* --------------------The submit event handler for the form---------------------------*/
$(document).ready(function() {
  $('#booking-form').submit(function(event) {
    event.preventDefault(); // Cancel the default form submission
    var numadults = localStorage.getItem('adult');
    var numchildren = localStorage.getItem('children');
    var formData = {
      // Getting values from input fields
      checkInDate: $('#inDate').val(),
      checkOutDate: $('#outDate').val(),
      name: $('#name').val(),
      surName: $('#surname').val(),
      numberOfAdults: numadults,
      numberOfChildren: numchildren,
      telephoneNumber: $('#phone').val(),
      email: $('#email').val(),
      room : {roomNumber: $('[name="roomNumber"]').val()} // Get roomNumber from the hidden input field

    };

    // Print form data to console
    console.log("Check-in Date: " + formData.checkInDate);
    console.log("Check-out Date: " + formData.checkOutDate);
    console.log("Name: " + formData.name);
    console.log("Surname: " + formData.surName);
    console.log("Email: " + formData.email);
    console.log("Telephone Number: " + formData.telephoneNumber);
    console.log("Room Number: " + formData.room.roomNumber);
//    console.log("Id: " + formData.room.Id);

    // Validate email
    if (!validateEmail(formData.email)) {
      alert("Please enter a valid email.");
      return;
    }

    // Validate phone
    if (!validatePhone(formData.telephoneNumber)) {
      alert("Please enter a valid phone number.");
      return;
    }

//    // Generate a random booking number
//    var bookingNumber = Math.floor(Math.random() * 100000);

    // Additional actions, such as sending data to the server
    $.ajax({
      url: '/api/reservation',
      type: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(formData),
      success: function(response) {
        console.log(response);

//      room : {reservId: $('[Id="Id"]').val()} // Get roomNumber from the hidden input field
    // Display a popup message
    var popup = $('#popup');

    var bookingNumberElement = $('#bookingNumber');
    bookingNumberElement.text(response.id);

    popup.show();
    // Close button event handler
    $('#closeButton').click(function() {
      popup.hide();
      localStorage.removeItem('rooms');       // clean data
      window.location.href = 'index.html';       // redirection
    });

      },
      error: function(xhr, status, error) {
        console.log(status);
      }
    });
  });
});

// Email validation function
function validateEmail(email) {
  var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}

// Phone validation function
function validatePhone(phone) {
  var regex = /^\d{10}$/;
  return regex.test(phone);
}

        //--------------------- Обработчик события submit для формы----------------------------//
        /* --------------------The submit event handler for the form---------------------------*/