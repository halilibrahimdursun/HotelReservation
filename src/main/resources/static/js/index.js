
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

     var smokingValue = $("#smoking").val();
     var smoking = (smokingValue === "0") ? false : true;

     var disabledValue = $("#disabled").val();
     var disabled = (disabledValue === "0") ? false : true;

     var cleaned = true;



    // Create an object with form data / Создание объекта с данными формы

//
    var formData = {
//      checkInDate: checkInDate,
//      checkOutDate: checkOutDate,
      capacityOfAdults: capacityOfAdults,
      capacityOfChildren: capacityOfChildren,
      smoking: smoking,
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
    console.log("Smoking: " + smoking);
    console.log("Disabled: " + disabled);
    console.log("Cleaned: " + cleaned);

    var criteria =JSON.stringify(formData);


    // Sending an AJAX request to the server // Отправка AJAX-запроса на сервер
 $.ajax({
   url: '/api/room/available?checkInDate=' + checkInDate + '&checkOutDate=' + checkOutDate,
   type: 'POST',
   contentType: 'application/json', // Add this line // Добавьте эту строку
    data: criteria, // Convert formData object to JSON format // Преобразуйте объект formData в формат JSON
   success: function(response) {
console.log(response);
localStorage.setItem('rooms', JSON.stringify(response));


localStorage.setItem('inDate', checkInDate);
localStorage.setItem('outDate', checkOutDate);
localStorage.setItem('adult', capacityOfAdults);
localStorage.setItem('children', capacityOfChildren);
localStorage.setItem('smoking', smoking);
localStorage.setItem('disabled', disabled);


window.location.href = 'rooms.html';
//window.location.href = 'room-single.html';


   },


   error: function(xhr, status, error) {
     console.log(status);
   }
 });

  });
});


///-----------------------END script for getting information from booking form ------------
