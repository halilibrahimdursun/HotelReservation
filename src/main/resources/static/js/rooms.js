

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

  var addedRoomTypes = []; // Track the room types that have been added

  if (storedRooms) {
    var rooms = JSON.parse(storedRooms);

// Sort the rooms array by price in ascending order
  rooms.sort(function(a, b) {
    return a.price - b.price;
  });

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
          var adult = room.capacityOfAdults;
          var children = room.capacityOfChildren;
          var bedType = room.typeOfBed;
          var special = room.smoking ? "Yes" : "No";
          var amenities = room.disabled ? "Yes" : "No";

          var roomLink = getRoomLink(roomName);

          var roomItem = $('<div class="col-lg-4 col-md-6">\
            <div class="room-item">\
              <form class="my-form">\
                <img src="' + imagePath + '" alt="">\
                <div class="ri-text">\
                  <h4>' + roomName + '</h4>\
                  <h3>' + roomPrice + '$<span>/Per night</span></h3>\
                  <table>\
                    <tbody>\
                      <tr>\
                        <td class="r-o">Adult:</td>\
                        <td> ' + adult + '</td>\
                      </tr>\
                       <tr>\
                        <td class="r-o">Children:</td>\
                        <td> ' + children + '</td>\
                      </tr>\
                      <tr>\
                        <td class="r-o">Bed:</td>\
                        <td>' + bedType + '</td>\
                      </tr>\
                      <tr>\
                        <td class="r-o">Smoking:</td>\
                        <td>' + special + '</td>\
                      </tr>\
                      <tr>\
                        <td class="r-o">Disabled:</td>\
                        <td>' + amenities + '</td>\
                      </tr>\
                    </tbody>\
                  </table>\
                  <a href="' + roomLink + '" class="primary-btn">Select room</a>\
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
//    localStorage.removeItem('rooms');
  } else {
    roomItems.html('<p>No rooms found.</p>');
  }

  function getRoomLink(roomType) {
    switch (roomType) {
      case 'Single':
        return './room-single.html';
      case 'Double':
        return './room-double.html';
      case '2xDouble':
        return './room-family.html';
      case 'Penthouse':
        return './room-penthouse.html';
      default:
        return '#';
    }
  }
});

