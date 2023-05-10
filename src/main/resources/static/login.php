<?php
// Проверка, была ли отправлена форма
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // Получение значений полей формы
  $username = $_POST["username"];
  $password = $_POST["password"];

  // Проверка подлинности (примерная проверка, требуется реализация соответствующей логики)
  if ($username === "admin" && $password === "password") {
    // Подлинность успешна, перенаправление на другую страницу
    header("Location: welcome.html");
    exit();
  } else {
    // Неправильные учетные данные, выведите сообщение об ошибке
    $error = "Invalid username or password.";
  }
}
?>
