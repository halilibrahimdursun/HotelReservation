function init(){
    // Add submit event to form for new and edit
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

  $('#inDate').val("2023-01-02");
  $('#outDate').val("2023-02-02");
  $('#adult').val("2");
  $('#children').val("1");
  $('#smoking').val("Smoking");
  $('#disabled').val("Non Disabled");

 var addedRoomTypes = []; // Track the room types that have been added
  var isFirstRoomAdded = false; // Flag to track if the first room has been added

  if (storedRooms) {
    var rooms = JSON.parse(storedRooms);

    // Sort the rooms array by price in ascending order
    rooms.sort(function(a, b) {
      return a.price - b.price;
    });

    if (rooms.length > 0) {
      rooms.forEach(function(room) {
        var roomType = room.typeOfRoom;

        // Check if the room type is 'Single' and the first room has not been added
        if (roomType === 'Double' && !isFirstRoomAdded) {
          addedRoomTypes.push(roomType); // Add the room type to the array


          // Rest of the code for creating the room item element
//          var imagePath = room.imageLink;
//          var roomName = room.typeOfRoom;

          var roomPrice = room.price;
          var maxCapacity = room.capacityOfGuests;
          var bedType = room.typeOfBed;
          var special = room.smoking ? "Yes" : "No";
          var amenities = room.facilities;
//          var roomLink = getRoomLink(roomName);

//          var roomPrice = "500";
//          var maxCapacity = "33";
//          var bedType = "room.typeOfBed";
//          var special = "room.smoking";
//          var amenities = "room.facilities";
//          var roomLink = getRoomLink(roomName);

  var roomItem = $('<h2><span>from </span>' + roomPrice + '<span>/Per night</span></h2>\
                              <table>\
                                  <tbody>\
                                  <tr>\
                                      <td class="r-o">Capacity:</td>\
                                      <td>Max persion ' + maxCapacity + '</td>\
                                  </tr>\
                                  <tr>\
                                      <td class="r-o">Bed:</td>\
                                      <td>' + bedType + '</td>\
                                  </tr>\
                                  <tr>\
                                      <td class="r-o">Services:</td>\
                                      <td>' + amenities + '</td>\
                                  </tr>\
                                  </tbody>\
                              </table>\
                             ');
          roomItems.append(roomItem);
           isFirstRoomAdded = true;
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

