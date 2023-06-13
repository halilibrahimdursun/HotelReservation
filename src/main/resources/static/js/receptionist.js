<script>
  const reservations = [
    // Burada, 'listReservations' adlı bir JavaScript dizisi oluşturarak tablodaki verileri temsil edeceğiz.
    // Verileri, Java ya da başka bir sunucu tarafı dilinden çekerek bu diziyi doldurabilirsiniz.
    // Örneğin:
    // { reservationNumber: 1, roomNumber: '101', telephoneNumber: '123456789', email: 'example@example.com', guests: 'John Doe', checkInDate: '2023-06-01', checkOutDate: '2023-06-08' },
    // { reservationNumber: 2, roomNumber: '102', telephoneNumber: '987654321', email: 'example2@example.com', guests: 'Jane Smith', checkInDate: '2023-06-02', checkOutDate: '2023-06-09' },
  ];

  function createTable() {
    let tableHTML = `
      <h1>Reservation List</h1>
      <a href="/index" class="btn btn-primary btn-sm mb-3">Add Reservation</a>
      <table border="1" class="table table-striped table-responsive-md">
        <thead>
          <tr>
            <th>Reservation Number</th>
            <th>Room Number</th>
            <th>Telephone Number</th>
            <th>Email</th>
            <th>Guest Name</th>
            <th>Check-in Date</th>
            <th>Check-out Date</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
    `;

    // reservations dizisindeki her bir rezervasyon için bir tablo satırı oluşturuyoruz
    reservations.forEach(reservation => {
      tableHTML += `
        <tr>
          <td>${reservation.reservationNumber}</td>
          <td>${reservation.roomNumber}</td>
          <td>${reservation.telephoneNumber}</td>
          <td>${reservation.email}</td>
          <td>${reservation.guests}</td>
          <td>${reservation.checkInDate}</td>
          <td>${reservation.checkOutDate}</td>
          <td>
            <a href="/showFormForUpdate/${reservation.id}" class="btn btn-primary">Update</a>
            <a href="/deleteReservation/${reservation.id}" class="btn btn-danger">Delete</a>
          </
