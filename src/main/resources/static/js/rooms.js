
<!-- AJAX request to get room data -->

    $(document).ready(function() {
        // Sending an AJAX request to the server to get room data
        $.ajax({
            url: '/api/room',
            method: 'GET',
            success: function(response) {
                var rooms = response;
                var roomItems = $('#roomItems');

                if (rooms.length > 0) {
                    rooms.forEach(function(room) {
                        var imagePath = room.imageLink;
                        var roomName = room.typeOfRoom;
                        var roomPrice = room.price;
                        var maxCapacity = room.capacityOfGuests;
                        var bedType = room.typeOfBed;
                        var special = room.isDisabled ? "Smoking" : "Non smoking";;
                        var amenities = room.facilities;

                        var roomItem = $('<div class="col-lg-4 col-md-6">\
                            <div class="room-item">\
                               <img src="' + imagePath + '" alt="">\
                                <div class="ri-text">\
                                    <h4>' + roomName + '</h4>\
                                    <h3>' + roomPrice + '<span>/Pernight</span></h3>\
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
                        </div>');

                        roomItems.append(roomItem);
                    });
                } else {
                    roomItems.html('<p>No rooms found.</p>');
                }
            },
            error: function() {
                var roomItems = $('#roomItems');
                roomItems.html('<p>Error retrieving room data.</p>');
            }
        });
    });