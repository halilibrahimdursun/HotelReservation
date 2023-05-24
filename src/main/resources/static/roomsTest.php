<?php
// Database connection / Подключение к базе данных
$servername = "localhost"; // Имя сервера базы данных
$username = "ваше_имя_пользователя"; // Имя пользователя базы данных
$password = "ваш_пароль"; // Пароль пользователя базы данных
$dbname = "ваша_база_данных"; // Имя базы данных

$conn = new mysqli($servername, $username, $password, $dbname);

// Connection test / Проверка соединения
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Executing a database query / Выполнение запроса к базе данных
$sql = "SELECT * FROM rooms";
$result = $conn->query($sql);

$rooms = array(); // Room storage array / Массив для хранения данных комнат

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {

        // Getting room data from a query result - Получение данных комнат из результата запроса

        $room = array(
            'image' => $row['image'],
            'name' => $row['name'],
            'price' => $row['price'],
            'capacity' => $row['capacity'],
            'bed_type' => $row['bed_type'],
            'amenities' => $row['amenities']
        );

        // Adding Room Data to an Array / Добавление данных комнат в массив
        $rooms[] = $room;
    }
}

// Closing the database connection / Закрытие соединения с базой данных

$conn->close();

// Returning room data in JSON format / Возвращение данных комнат в формате JSON

header('Content-Type: application/json');
echo json_encode($rooms);
?>
