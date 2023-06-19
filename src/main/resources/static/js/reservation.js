var api = "http://localhost:8080/api/reservation" ;
var reservationTable;

function init(){

    console.log('inside init' );

    $("#radio_1").attr('checked', true);
    $("#newReservationButton").click(function() {
        console.log("Inside click of newReservationButton");
        window.location.href = "index.html";
    });

    $("#editReservationButton").click( function () {
        console.log("Inside click of editReservationButton");
        // Get the data from selected row and fill fields in modal

        if (reservationTable.row($('.selected')).data() == undefined) {
            alert("Select reservation first");
        }else{
            var reservation = reservationTable.row($('.selected')).data();
            alert(reservation.id);
            $("#id").val(reservation.id);
            $("#checkInDate").val(reservation.checkInDate);
            $("#checkOutDate").val(reservation.checkOutDate);
            $("#name").val(reservation.name);
            $("#surName").val(reservation.surName);
            $("#email").val(reservation.email);
            $("#telephoneNumber").val(reservation.telephoneNumber);
            $("#roomNumber").val(reservation.room.roomNumber);
            localStorage.setItem('roomNumber', reservation.room.roomNumber);
            $('#reservationModal').modal('show');
        }
    });

    $("#deleteReservationButton").click( function () {
        console.log("Inside click of deleteReservationButton");

        if (reservationTable.row($('.selected')).data() == undefined) {
            alert("Select reservation first");
        }else{
            $('#reservationDeleteModal').modal('show');
        }
    });

    // Button in modal
    $("#deleteReservationConfirmButton").click( function () {
        console.log("Inside click of deleteReservationButton");
        deleteReservation();
        $('#reservationDeleteModal').modal('hide');
    });

    // Add submit event to form for new and edit
    $("#reservationForm").on('submit', function() {
        console.log("Submitting");
        createReservation();
        $('#reservationModal').modal('hide');
    });

    initReservationTable();
    // Get reservations from backend and update table
    getReservationData();
}

function initReservationTable() {

    console.log('inside initReservationTable' );

     // Create columns (with titles) for datatable: id, name, address, age
        columns = [
            { "title":  "Reservation ID",
                "data": "id",
                "visible": true },
            { "title":  "Check-in",
                "data": "checkInDate" },  // 2022-06-08T08:09:18.922
            { "title":  "Check-out",
                "data": "checkOutDate" },
            { "title":  "Name",
            "data": "name" },
            { "title":  "Surname",
            "data": "surName" },
            { "title":  "Email",
            "data": "email" },
            { "title":  "Telephone number",
            "data": "telephoneNumber" },
            { "title":  "Adults",
            "data": "numberOfAdults" },
            { "title":  "Children",
                "data": "numberOfChildren" },
            { "title":  "Room",
            "data": "room.roomNumber" }
        ];

    // Define new table with above columns
    reservationTable = $("#reservationTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });


    $("#reservationTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
          // emptyRoomModals();
        }
        else {
            reservationTable.$('tr.selected').removeClass('selected');
          // emptyRoomModals();
            $(this).addClass('selected');
        }
    });
}

function getReservationData(){

    console.log('inside getReservationData' );
    // http:/localhost:8080/api/reservation
    // json list of reservations
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(reservations, textStatus, jqXHR){
        success: function(reservations){
 //           console.log('Data: ' + reservations );
            if (reservations) {
                reservationTable.clear();
                reservationTable.rows.add(reservations);
                reservationTable.columns.adjust().draw();
            }
        },
        fail: function (error) {
            console.log('Error: ' + error);
        }
    });
}

//=========== createReservation DOESNT WORK============
function createReservation(){

    console.log('inside createReservation' );

        var inDate = localStorage.getItem('inDate');
        var outDate = localStorage.getItem('outDate');
        var adult = localStorage.getItem('adult');
        var children = localStorage.getItem('children');
        var roomNumber = localStorage.getItem('roomNumber');

    // Put reservation data from page in Javascript object --- SIMILAR TO JSON
    var reservationData = {
            id: $("#id").val(),
            checkInDate: inDate,
            checkOutDate: outDate,
            name: $("#name").val(),
            surName: $("#surName").val(),
            numberOfAdults: adult,
            numberOfChildren: children,
            email: $("#email").val(),
            telephoneNumber: $("#telephoneNumber").val(),
//            roomNumber: $("#roomNumber").val(),
            room : {roomNumber:roomNumber}
    }

    // Transform Javascript object to json
    var reservationJson = JSON.stringify(reservationData);

    console.log(reservationJson);

    $.ajax({
        url: '/api/reservation',
        type: 'POST',
        data: reservationJson,    // json for request body
        contentType:"application/json", //; charset=utf-8",   // What we send to frontend
//        dataType: "json",  // get back from frontend
        // success: function(reservation, textStatus, jqXHR){
        success: function(reservation){
          console.log(reservation);

          // Clear fields in page
//          $("#id").val('');
//          $("#name").val('');
//          $("#address").val('');
//          $("#age").val('');

          // Refresh table data
          getReservationData();

          // Применить язык к новой форме. Запускаем перевод после создания каждой формы
                    applyLanguage(selectedLanguage);


        },
        fail: function (error) {
          console.log('Error: ' + error);
        }
    });
}
//=======================================================================================

function deleteReservation(){

    if (reservationTable.row($('.selected')).data() == undefined) {
        alert("Select reservation first");
    }else{
        var reservation = reservationTable.row($('.selected')).data();

        console.log(api + '/' + reservation.id);

            $.ajax({
                url: api + '/' + reservation.id,
                type: "delete",
                contentType: "application/json",
                dataType: "text",  // get back from frontend
                // success: function(reservation, textStatus, jqXHR){
                success: function(message){
                  console.log(message);

                  // Refresh table data
                  getReservationData();
                },
                fail: function (error) {
                  console.log('Error: ' + error);
                }
            });
    }
}
