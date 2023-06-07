

$(document).ready(function() {
  var roomItems = $('#roomItems');
  var storedRooms = localStorage.getItem('rooms');
  var inDate = localStorage.getItem('inDate');
  var outDate = localStorage.getItem('outDate');
  console.log(inDate,outDate);

  $('#inDate').val("123");
  $('#outDate').val("345");

  var addedRoomTypes = []; // Track the room types that have been added

  if (storedRooms) {
    var rooms = JSON.parse(storedRooms);

    if (rooms.length > 0) {
      rooms.forEach(function(room) {
        var roomType = room.typeOfRoom;

        // Check if the room type has already been added
        if (addedRoomTypes.indexOf(roomType) === -1) {
          addedRoomTypes.push(roomType); // Add the room type to the array

          // Rest of the code for creating the room item element
          var imagePath = room.imageLink;
          var roomName = room.typeOfRoom;
          var roomPrice = room.price;
          var maxCapacity = room.capacityOfGuests;
          var bedType = room.typeOfBed;
          var special = room.isDisabled ? "Smoking" : "Non smoking";
          var amenities = room.facilities;

          var roomItem = $('<div class="col-lg-4 col-md-6">\
            <div class="room-item">\
              <form class="my-form">\
                <img src="' + imagePath + '" alt="">\
                <div class="ri-text">\
                  <h4>' + roomName + '</h4>\
                  <h3>' + roomPrice + '$<span>/Pernight</span></h3>\
                  <table>\
                    <tbody>\
                      <tr>\
                        <td class="r-o">Capacity:</td>\
                        <td>Max person ' + maxCapacity + '</td>\
                      </tr>\
                      <tr>\
                        <td class="r-o">Bed:</td>\
                        <td>' + bedType + '</td>\
                      </tr>\
                      <tr>\
                        <td class="r-o">Special:</td>\
                        <td>' + special + '</td>\
                      </tr>\
                      <tr>\
                        <td class="r-o">Services:</td>\
                        <td>' + amenities + '</td>\
                      </tr>\
                    </tbody>\
                  </table>\
                  <a href="./room-single.html" class="primary-btn">More Details</a>\
                </div>\
              </div>\
            </form>\
          </div>');

          roomItems.append(roomItem);
        }
      });
    } else {
      roomItems.html('<p>No rooms found.</p>');
    }
    localStorage.removeItem('rooms');
  } else {
    roomItems.html('<p>No rooms found.</p>');
  }
});



