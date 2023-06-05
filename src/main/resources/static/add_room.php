<?php
// Подключение к базе данных (примерный код, требуется реальная конфигурация)
$servername = "localhost";
$username = "your_username";
$password = "your_password";
$dbname = "your_database";

$conn = new mysqli($servername, $username, $password, $dbname);

// Проверка соединения
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

// Проверка, была ли отправлена форма
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // Получение значений полей формы
  $roomNumber = $_POST["room_number"];
  $roomType = $_POST["room_type"];
  $price = $_POST["price"];

  // Подготовка и выполнение SQL-запроса для добавления данных в базу данных (примерный код, требуется реальная реализация)
  $sql = "INSERT INTO hotel_rooms (room_number, room_type, price) VALUES ('$roomNumber', '$roomType', '$price')";

  if ($conn->query($sql) === TRUE) {
    // Данные успешно добавлены в базу данных
    echo "Room added successfully!";
  } else {
    // Возникла ошибка при добавлении данных в базу данных
    echo "Error: " . $sql . "<br>" . $conn->error;
  }
}

// Закрытие соединения с базой данных
$conn->close();
?>
