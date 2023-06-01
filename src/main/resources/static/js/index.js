//
/////-----------------------script for button of the booking form ------------
//
//function init(){
//    // Add submit event to form for new and edit
//    $("#booking-form").on('submit', function() {
//        console.log("Submitting");
//    });
//}
/////-----------------------END script for button of the booking form ------------
//
//
/////-----------------------script for getting information from booking form ------------
//
//  $(document).ready(function() {
//    $("#booking-form").on('submit', function(event) {
//      event.preventDefault(); // Page Reload Prevention / Предотвращение перезагрузки страницы
//
//      // Getting form field values / Получение значений полей формы
//      var dateIn = $("#date-in").val();
//      var dateOut = $("#date-out").val();
//      var adultValue = $("#adult").val();
//      var childrenCount = $("#children").val();
//      var roomOptions = $("#options").val();
//
//      // Performing More Actions on Form Data / Выполнение дополнительных действий с данными формы
//      console.log("Form submitted");
//      console.log("Check-in date: " + dateIn);
//      console.log("Check-out date: " + dateOut);
//      console.log("Selected Adult:", adultValue);
//      console.log("Children count: " + childrenCount);
//      console.log("Selected Room options:", roomOptions);
//
//      // Sending an AJAX request to the server / Отправка AJAX-запроса на сервер
//      $.ajax({
//        url: '/booking', // Path to your handler on the server / Путь к вашему обработчику на сервере
//        type: 'POST',
//        data: {
//          dateIn: dateIn,
//          dateOut: dateOut,
//          adultValue: adultValue,
//          childrenCount: childrenCount,
//          roomOptions: roomOptions
//        },
//        success: function(response) {
//          // Handling a successful response from the server / Обработка успешного ответа от сервера
//          console.log(response);
//        },
//        error: function(xhr, status, error) {
//          // Error Handling / Обработка ошибки
//          console.log(error);
//        }
//      });
//    });
//  });
/////-----------------------END script for getting information from booking form ------------


///-----------------------script for button of the booking form ------------

function init(){
    // Add submit event to form for new and edit
    $("#booking-form").on('submit', function() {
    console.log("Submitting");
    });
}

///-----------------------END script for button of the booking form ------------


///-----------------------script for getting information from booking form ------------

//$(document).ready(function() {
//  $("#booking-form").on('submit', function(event) {
//    event.preventDefault(); // Page Reload Prevention
//
//    // Getting form field values
//    var dateIn = $("#date-in").val();
//    var dateOut = $("#date-out").val();
//    var adultValue = $("#adult").val();
//    var childrenCount = $("#children").val();
//    var roomOptions = $("#options").val();
//
//    // Performing More Actions on Form Data
//    console.log("Form submitted");
//    console.log("Check-in date: " + dateIn);
//    console.log("Check-out date: " + dateOut);
//    console.log("Selected Adult: " + adultValue);
//    console.log("Children count: " + childrenCount);
//    console.log("Selected Room options: " + roomOptions);
//
//    // Sending an AJAX request to the server
//    $.ajax({
//      url: '/booking',
//      type: 'POST',
//      data: {
//        dateIn: dateIn,
//        dateOut: dateOut,
//        adultValue: adultValue,
//        childrenCount: childrenCount,
//        roomOptions: roomOptions
//      },
//      success: function(response) {
//        // Handling a successful response from the server
//        console.log(response);
//
//        // Update the UI with the filtered room data received from the server
//        // You can use the response data to display the filtered rooms on the webpage
//      },
//      error: function(xhr, status, error) {
//        // Error Handling
//        console.log(error);
//      }
//    });
//  });
//});

///-----------------------END script for getting information from booking form ------------


$(document).ready(function() {
  $("#booking-form").on('submit', function(event) {
    event.preventDefault(); // Page Reload Prevention // Предотвращение перезагрузки страницы

    // Getting form field values // Получение значений полей формы
    var cleaned = $("#cleaned").is(":checked");
    var disabled = $("#disabled").is(":checked");
    var dateIn = $("#date-in").val();
    var dateOut = $("#date-out").val();
    var adultValue = $("#adult").val();
    var childrenCount = $("#children").val();
    var roomOptions = $("#options").val();
    // Get the rest of the form field values// Получите остальные значения полей формы

    // Create an object with form data / Создание объекта с данными формы
    var formData = {
      cleaned: cleaned,
      disabled: disabled,
      dateIn: dateIn,
      dateOut: dateOut,
      adultValue: adultValue,
      childrenCount: childrenCount,
      roomOptions: roomOptions
      // Add the rest of the formData object properties based on the form fields
      //Добавьте остальные свойства объекта formData на основе полей формы
    };

// Performing More Actions on Form Data
    console.log("Form submitted");
    console.log("Check-in date: " + dateIn);
    console.log("Check-out date: " + dateOut);
    console.log("Selected Adult: " + adultValue);
    console.log("Children count: " + childrenCount);
    console.log("Selected Room options: " + roomOptions);

    // Sending an AJAX request to the server // Отправка AJAX-запроса на сервер
 $.ajax({
   url: '/api/room/filtered',
   type: 'POST',
   contentType: 'application/json', // Add this line // Добавьте эту строку
   data: JSON.stringify(formData), // Convert formData object to JSON format // Преобразуйте объект formData в формат JSON
   success: function(response) {
     // Handling a successful response from the server // Обработка успешного ответа от сервера
     // Update the user interface with filtered rooms // Обновите пользовательский интерфейс с отфильтрованными комнатами
   },
   error: function(xhr, status, error) {
     // Error Handling // Обработка ошибки
   }
 });

  });
});
