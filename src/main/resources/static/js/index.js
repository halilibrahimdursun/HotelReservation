
///-----------------------script for button of the booking form ------------

function init(){
    // Add submit event to form for new and edit
    $("#booking-form").on('submit', function() {
    console.log("Submitting");
    });
}

///-----------------------END script for button of the booking form ------------


///-----------------------script for getting information from booking form ------------

$(document).ready(function() {
  $("#booking-form").on('submit', function(event) {
    event.preventDefault(); // Page Reload Prevention // Предотвращение перезагрузки страницы

    // Getting form field values // Получение значений полей формы
     var checkInDate = $("#date-in").val();
     var checkOutDate = $("#date-out").val();
     var capacityOfAdults = $("#adult").val();
     var capacityOfChildren = $("#children").val();
     var smockingValue = $("#smocking").val();
     var smocking = (smockingValue === "0") ? false : true;
     var disabledValue = $("#disabled").val();
     var disabled = (disabledValue === "0") ? false : true;
     var cleaned = false;



    // Create an object with form data / Создание объекта с данными формы

//
    var formData = {
      checkInDate: checkInDate,
      checkOutDate: checkOutDate,
      capacityOfAdults: capacityOfAdults,
      capacityOfChildren: capacityOfChildren,
      smocking: smocking,
      disabled: disabled,
      cleaned: cleaned
//      // Add the rest of the formData object properties based on the form fields
//      //Добавьте остальные свойства объекта formData на основе полей формы
    };

// Performing More Actions on Form Data
    console.log("Form submitted");
    console.log("Check-in date: " + checkInDate);
    console.log("Check-out date: " + checkOutDate);
    console.log("Selected Adult: " + capacityOfAdults);
    console.log("Children count: " + capacityOfChildren);
    console.log("Smocking: " + smocking);
    console.log("Disabled: " + disabled);




    // Sending an AJAX request to the server // Отправка AJAX-запроса на сервер
 $.ajax({
   url: '/api/room/available?checkInDate=' + checkInDate + '&checkOutDate=' + checkOutDate,
   type: 'POST',
   contentType: 'application/json', // Add this line // Добавьте эту строку
    data: JSON.stringify(formData), // Convert formData object to JSON format // Преобразуйте объект formData в формат JSON
   success: function(rooms) {
     // Handling a successful response from the server // Обработка успешного ответа от сервера
     // Update the user interface with filtered rooms // Обновите пользовательский интерфейс с отфильтрованными комнатами
   },
   error: function(xhr, status, error) {
     // Error Handling // Обработка ошибки
   }
 });

  });
});


///-----------------------END script for getting information from booking form ------------
