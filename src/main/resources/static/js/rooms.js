
//------------------------------------------------------------------------------------
//
//$(document).ready(function() {
//    // Sending an AJAX request to the server to get room data
//    $.ajax({
//        url: '/api/room/available',
//        method: 'GET',
//        success: function(response) {
//            console.log(response); // Выводим полученный ответ в консоль
//            var rooms = response; // Присваиваем полученный ответ переменной rooms
//            var roomItems = $('#roomItems');
//
//            if (rooms.length > 0) {
//                rooms.forEach(function(room) {
//                    var imagePath = room.imageLink;
//                    var roomName = room.typeOfRoom;
//                    var roomPrice = room.price;
//                    var maxCapacity = room.capacityOfGuests;
//                    var bedType = room.typeOfBed;
//                    var special = room.isDisabled ? "Smoking" : "Non smoking";
//                    var amenities = room.facilities;
//
//                    var roomItem = $('<div class="col-lg-4 col-md-6">\
//                        <div class="room-item">\
//                            <form class="my-form">\
//                                <img src="' + imagePath + '" alt="">\
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
//                            </form>\
//                        </div>\
//                    </div>');
//
//                    roomItems.append(roomItem);
//                });
//            } else {
//                roomItems.html('<p>No rooms found.</p>');
//            }
//        },
//        error: function() {
//            var roomItems = $('#roomItems');
//            roomItems.html('<p>Error retrieving room data.</p>');
//        }
//    });
//});
//
//


$.ajax({
  url: '/api/room/available?checkInDate=' + checkInDate + '&checkOutDate=' + checkOutDate,
  type: 'POST',
  contentType: 'application/json',
  data: JSON.stringify(formData),
  success: function(response) {
    console.log(response); // Вывод ответа в консоль
    var rooms = response;
    var roomItems = $('#roomItems');
    roomItems.empty(); // Очистить предыдущие результаты

    // Перебрать полученные комнаты и создать элементы комнаты
    for (var i = 0; i < rooms.length; i++) {
      var room = rooms[i];
      var roomItem = $('<div class="col-lg-4 col-md-6">\
                        <div class="room-item">\
                            <form class="my-form">\
                                <img src="' + room.imageLink + '" alt="">\
                                <div class="ri-text">\
                                    <h4>' + room.typeOfRoom + '</h4>\
                                    <h3>' + room.price + '$<span>/Pernight</span></h3>\
                                    <table>\
                                        <tbody>\
                                            <tr>\
                                                <td class="r-o">Capacity:</td>\
                                                <td>Max person ' + room.capacityOfGuests + '</td>\
                                            </tr>\
                                            <tr>\
                                                <td class="r-o">Bed:</td>\
                                                <td>' + room.typeOfBed + '</td>\
                                            </tr>\
                                            <tr>\
                                                <td class="r-o">Special:</td>\
                                                <td>' + room.facilities + '</td>\
                                            </tr>\
                                        </tbody>\
                                    </table>\
                                    <a href="./room-single.html" class="primary-btn">More Details</a>\
                                </div>\
                            </form>\
                        </div>\
                    </div>');

      roomItems.append(roomItem); // Добавить элемент комнаты в родительский контейнер
    }
  },
  error: function(xhr, status, error) {
    // Обработка ошибки
    console.log("Error:", error);
  }
});
