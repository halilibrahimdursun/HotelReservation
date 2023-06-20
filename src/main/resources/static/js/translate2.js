function initReservationTable() {
  console.log('inside initReservationTable');

  // Create columns (with titles) for datatable: id, name, address, age
  columns = [
    { "title":  "Reservation ID", "data": "id", "visible": true },
    { "title":  "Check-in", "data": "checkInDate" },
    { "title":  "Check-out", "data": "checkOutDate" },
    { "title":  "Name", "data": "name" },
    { "title":  "Surname", "data": "surName" },
    { "title":  "Email", "data": "email" },
    { "title":  "Telephone number", "data": "telephoneNumber" },
    { "title":  "Adults", "data": "numberOfAdults" },
    { "title":  "Children", "data": "numberOfChildren" },
    { "title":  "Room", "data": "room.roomNumber" }
  ];

  // Define new table with above columns
  reservationTable = $("#reservationTable").DataTable({
    "order": [[ 0, "asc" ]],
    "columns": columns
  });

  $("#reservationTable tbody").on('click', 'tr', function () {
    console.log("Clicking on row");
    if ($(this).hasClass('selected')) {
      $(this).removeClass('selected');
      // emptyRoomModals();
    }
    else {
      reservationTable.$('tr.selected').removeClass('selected');
      // emptyRoomModals();
      $(this).addClass('selected');
    }
  });

  // Apply language to table headers
  applyTableHeadersLanguage();
}


//---------------------------------------------



function applyTableHeadersLanguage() {
  const language = localStorage.getItem('selectedLanguage') || 'EN';

  const translations = {
    EN: {
      'Reservation ID': 'Reservation ID',
      'Check-in': 'Check-in',
      'Check-out': 'Check-out',
      'Name': 'Name',
      'Surname': 'Surname',
      'Email': 'Email',
      'Telephone number': 'Telephone number',
      'Adults': 'Adults',
      'Children': 'Children',
      'Room': 'Room'
    },
    CN: {
      'Reservation ID': '预订编号',
      'Check-in': '入住日期',
      'Check-out': '退房日期',
      'Name': '姓名',
      'Surname': '姓氏',
      'Email': '电子邮件',
      'Telephone number': '电话号码',
      'Adults': '成人',
      'Children': '儿童',
      'Room': '房间'
    }
  };

  const headers = document.querySelectorAll('#reservationTable thead th');

headers.forEach((header) => {
  const translation = translations[language][header.textContent.trim()];
  if (translation) {
    $(header).text(translation); // Обновляем текст заголовка с помощью jQuery
  }
});

  console.log('Table headers updated');
}




// Восстанавливаем выбранный язык из Local Storage (если сохранен)
const selectedLanguage = localStorage.getItem('selectedLanguage');
if (selectedLanguage) {
  const languageToggle = document.getElementById('language-toggle');
  languageToggle.textContent = selectedLanguage;

  // Применяем выбранный язык при загрузке страницы
  applyTableHeadersLanguage();
}

function toggleLanguage() {
  const languageToggle = document.getElementById('language-toggle');
  const currentLanguage = languageToggle.textContent;
  const newLanguage = currentLanguage === 'EN' ? 'CN' : 'EN';
  languageToggle.textContent = newLanguage;

  // Сохраняем выбранный язык в Local Storage
  localStorage.setItem('selectedLanguage', newLanguage);

  // Обновляем страницу
  location.reload();

  console.log('Language toggled');
}

// Добавляем обработчик события click для кнопки переключения языка
document.getElementById('language-toggle').addEventListener('click', toggleLanguage);
