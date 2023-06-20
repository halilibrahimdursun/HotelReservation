var api = "http://localhost:8080/api/room" ;
var api2 = "http://localhost:8080/api/reservation" ;
var reservationTable;
var roomsToBeCleaned;

function init(){

    console.log('inside init' );

    $("#radio_1").attr('checked', true);
    $("#saveCleanedRooms").click(function() {
        console.log("Inside click of saveCleanedRooms");
    });


    // Add submit event to form for new and edit
    $("#reservationForm").on('submit', function() {
        console.log("Submitting");
        createReservation();
        $('#reservationModal').modal('hide');
    });

    initRoomsToBeCleaned();
    getReservedRooms();
}
function initRoomsToBeCleaned() {

    console.log('inside initRoomsToBeCleaned' );

     // Create columns (with titles) for datatable: id, name, address, age
        columns = [
//            { "title":  "Reservation ID",
//                "data": "id",
//                "visible": true },
            { "title":  "Room Number",
                "data": "roomNumber" },  // 2022-06-08T08:09:18.922
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
        "columns": columns
    });
}
function getReservedRooms(){

    console.log('inside getReservedRooms' );
    // http:/localhost:8080/api/reservation
    // json list of reservations
    $.ajax({
        url: api2,
        type: "get",
        dataType: "json",
        // success: function(reservations, textStatus, jqXHR){
        success: function(reservations){
 //           console.log('Data: ' + reservations );
            if (reservations.length > 0) {
            reservations.forEach(function(reservation) {
                console.log(reservation.room.roomNumber)
                    var rowData = [
                        reservation.room.roomNumber, // Add room number to the "Room Number" column
                        false // Set cleanedStatus to empty by default
                    ];

                    // Add the new row data to the specific columns of the DataTable
                    roomsToBeCleaned.row.add(rowData);
                });

                // Redraw the table to reflect the changes
                roomsToBeCleaned.draw();
            }
        },
        fail: function (error) {
            console.log('Error: ' + error);
        }
    });
}
