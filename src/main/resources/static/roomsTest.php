<?php

$imagePath = null;

$conn = new mysqli("localhost", "username", "password", "database");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM rooms WHERE availability = 'available'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $imagePath = $row['image'];
        $roomName = $row['name'];
        $roomPrice = $row['price'];
        $maxCapacity = $row['capacity'];
        $bedType = $row['bed_type'];
        $amenities = $row['amenities'];

        // Include the HTML code here or pass the variables to the HTML file
        include 'example.html';
    }
} else {
    echo "No available rooms found.";
}

$conn->close();
?>
