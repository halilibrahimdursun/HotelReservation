var api = "http://localhost:8080/api/rooms" ;
var api2 = "http://localhost:8080/api/reservation" ;
var reservationTable;
var roomsToBeCleaned;

function init(){

    console.log('inside init' );




    // Add submit event to form for new and edit
    $("#reservationForm").on('submit', function() {
        console.log("Submitting");
        createReservation();
        $('#reservationModal').modal('hide');
    });

    initRoomsToBeCleaned();
    getUncleanedRooms();

        $("#radio_1").attr('checked', true);
        $("#saveCleanedRooms").click(function() {
            console.log("Inside click of saveCleanedRooms");
            deleteSelectedRows();
            window.location.href = "./room";
            console.log(roomsToBeCleaned);
        });
}
function initRoomsToBeCleaned() {

    console.log('inside initRoomsToBeCleaned' );

     // Create columns (with titles) for datatable: id, name, address, age
        columns = [
//            { "title":  "Reservation ID",
//                "data": "id",
//                "visible": true },
            { "title":  "Room Number",
                "data": null },
            { "title":  "Cleaned",
                "data": null,
                "render": function (data, type, row) {
                    // Render a checkbox in the "Cleaned" column
//                    return '<input type="checkbox" ' + (data ? 'checked' : '') + '>';
                    return '<input type="checkbox">';
                }
            }
        ];

    // Define new table with above columns
    roomsToBeCleaned = $("#roomsToBeCleaned").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns,
    });
}
function getUncleanedRooms(){

    console.log('inside getUncleanedRooms' );
    // http:/localhost:8080/api/reservation
    // json list of reservations
       $.ajax({
            url: api,
            type: "get",
            dataType: "json",
            success: function(rooms){
                if (rooms.length > 0) {
                rooms.forEach(function(room) {
                if (room.cleaned == false){
    //console.log(reservation.checkOutDate)
                        roomsToBeCleaned.row.add(room.roomNumber);
                        }
                    });
                    // Redraw the table to reflect the changes
                    roomsToBeCleaned.draw();
                }
            },
            fail: function (error) {
                console.log('Error: ' + error);
            }
        });
//    $.ajax({
//        url: api2,
//        type: "get",
//        dataType: "json",
//        success: function(reservations){
//            if (reservations.length > 0) {
//            reservations.forEach(function(reservation) {
//            var today = new Date(); // Get the current local date
//            var todayDate = today.toISOString().split('T')[0]; // Format as YYYY-MM-DD
//            if (reservation.checkOutDate == todayDate){
////console.log(reservation.checkOutDate)
//                console.log(reservation.room.roomNumber);
//                    roomsToBeCleaned.row.add(reservation.room.roomNumber);
//                    }
//                });
//                // Redraw the table to reflect the changes
//                roomsToBeCleaned.draw();
//            }
//        },
//        fail: function (error) {
//            console.log('Error: ' + error);
//        }
//    });
}
function deleteSelectedRows() {

    roomsToBeCleaned.rows().every(function() {
        var checkbox = $(this.node()).find('input[type="checkbox"]');
        var roomNumber = this.data(); // Assuming the room number column is at index 0
        console.log(roomNumber);

        if (checkbox.is(":checked")) {
        var criteria = {
                  roomNumber: roomNumber,
                  cleaned: true
            }
            console.log(criteria);
                   $.ajax({
                        url: api,
                        type: "post",
                        contentType: 'application/json', // Add this line // Добавьте эту строку
                        data: JSON.stringify(criteria),
                        success: function(rooms){
                        },
                        fail: function (error) {
                            console.log('Error: ' + error);
                        }
                    });
        }
    });



}