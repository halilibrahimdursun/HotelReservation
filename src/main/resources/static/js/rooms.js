
//------------------------------------------------------------------------------------

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
            },
            error: function() {
                var roomItems = $('#roomItems');
                roomItems.html('<p>Error retrieving room data.</p>');
            }
        });
    });


//
//
function init() {
    // Add submit event to form for new and edit
    $("#booking-form").on('submit', function() {
        console.log("Submitting");
    });
}
//
//$(document).ready(function() {
//    init(); // Call init function
//
//    $("#booking-form").on('submit', function(event) {
//        event.preventDefault(); // Prevent page reload
//
//        var dateIn = $("#date-in").val();
//        var dateOut = $("#date-out").val();
//        var capacityOfAdults = $("select[name='capacityOfAdults']").val();
//        var capacityOfChildren = $("select[name='capacityOfChildren']").val();
//        var isSmoking = $("#smoking").is(":checked");
//        var isDisabled = $("#disabled").is(":checked");
//
//        var filterData = {
//            dateIn: dateIn,
//            dateOut: dateOut,
//            capacityOfAdults: capacityOfAdults,
//            capacityOfChildren: capacityOfChildren,
//            isSmoking: isSmoking,
//            isDisabled: isDisabled
//        };
//
//        // Performing More Actions on Form Data
//        console.log("Form submitted");
//        console.log("Check-in date: " + dateIn);
//        console.log("Check-out date: " + dateOut);
//        console.log("Selected Adult: " + capacityOfAdults);
//        console.log("Children count: " + capacityOfChildren);
//        console.log("Smocking: " + isSmoking);
//        console.log("Disabled: " + isDisabled);
//
//        $.ajax({
//            url: '/api/room/filtered',
//            method: 'POST',
//            contentType: 'application/json',
//            data: JSON.stringify(filterData),
//            success: function(response) {
//                var rooms = response;
//                 console.log(rooms); // Outputting room data to the console // Вывод данных комнат в консоль
//                var roomItems = $('#roomItems');
//                roomItems.empty(); // Clear existing room items
//
//                if (rooms.length > 0) {
//                    rooms.forEach(function(room) {
//                        var imagePath = room.imageLink;
//                        var roomName = room.typeOfRoom;
//                        var roomPrice = room.price;
//                        var maxCapacity = room.capacityOfGuests;
//                        var bedType = room.typeOfBed;
//                        var special = room.isDisabled ? "Smoking" : "Non smoking";
//                        var amenities = room.facilities;
//
//                        var roomItem = $('<div class="col-lg-4 col-md-6">\
//                            <div class="room-item">\
//                                <form class="my-form">\
//                                    <img src="' + imagePath + '" alt="">\
//                                    <div class="ri-text">\
//                                        <h4>' + roomName + '</h4>\
//                                        <h3>' + roomPrice + '$<span>/Pernight</span></h3>\
//                                        <table>\
//                                            <tbody>\
//                                                <tr>\
//                                                    <td class="r-o">Capacity:</td>\
//                                                    <td>Max person ' + maxCapacity + '</td>\
//                                                </tr>\
//                                                <tr>\
//                                                    <td class="r-o">Bed:</td>\
//                                                    <td>' + bedType + '</td>\
//                                                </tr>\
//                                                <tr>\
//                                                    <td class="r-o">Special:</td>\
//                                                    <td>' + special + '</td>\
//                                                </tr>\
//                                                <tr>\
//                                                    <td class="r-o">Services:</td>\
//                                                    <td>' + amenities + '</td>\
//                                                </tr>\
//                                            </tbody>\
//                                        </table>\
//                                        <a href="./room-single.html" class="primary-btn">More Details</a>\
//                                    </div>\
//                                </form>\
//                            </div>\
//                        </div>');
//
//                        roomItems.append(roomItem);
//                    });
//                } else {
//                    roomItems.html('<p>No rooms found.</p>');
//                }
//            },
//            error: function() {
//                var roomItems = $('#roomItems');
//                roomItems.html('<p>Error retrieving filtered room data.</p>');
//            }
//        });
//    });
//});
