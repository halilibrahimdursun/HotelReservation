

$(document).ready(function() {
  var roomItems = $('#roomItems');
  var storedRooms = localStorage.getItem('rooms');
  if (storedRooms) {
    var rooms = JSON.parse(storedRooms);
    if (rooms.length > 0) {
      rooms.forEach(function(room) {
        console.log(room);
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
      });
    } else {
      roomItems.html('<p>No rooms found.</p>');
    }
    localStorage.removeItem('rooms'); // Clear the data from localStorage
  } else {
    roomItems.html('<p>No rooms found.</p>');
  }
});


