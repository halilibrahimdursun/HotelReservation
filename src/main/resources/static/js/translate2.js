// Восстанавливаем выбранный язык из local Storage (если сохранен)
const selectedLanguage = localStorage.getItem('selectedLanguage');

function applyLanguage(language) {
  const elements = document.querySelectorAll('.nav-menu ul li a, h1, h2, h3, h4, h6, label, option, span, button, td, a, p, br');
  const translations = {
    EN: {
      'Home': '首页',
      'About Us': '关于我们',
      'Contact': '联系我们',
      'Login': '登录',
      'Reservation ID': 'Идентификатор брони',
      'Check-in': 'Дата заезда',
      'Check-out': 'Дата выезда',
      'Name': 'Имя',
      'Surname': 'Фамилия',
      'Email': 'Эл. почта',
      'Telephone number': 'Номер телефона',
      'Adults': 'Взрослые',
      'Children': 'Дети',
      'Room': 'Номер комнаты'
    },
    CN: {
      '首页': 'Home',
      '关于我们': 'About Us',
      '联系我们': 'Contact',
      '登录': 'Login',
      'Идентификатор брони': 'Reservation ID',
      'Дата заезда': 'Check-in',
      'Дата выезда': 'Check-out',
      'Имя': 'Name',
      'Фамилия': 'Surname',
      'Эл. почта': 'Email',
      'Номер телефона': 'Telephone number',
      'Взрослые': 'Adults',
      'Дети': 'Children',
      'Номер комнаты': 'Room'
    }
  };

  function translate(title) {
    if (translations[language] && translations[language][title]) {
      return translations[language][title];
    }
    return title;
  }

  elements.forEach(function (element) {
    let elementText = element.textContent.trim();

    if (element.nodeName === 'LABEL' && element.hasAttribute('for')) {
      const forAttr = element.getAttribute('for');
      const labelText = element.childNodes[0].textContent.trim();
      elementText = `${labelText}`;
    }

    const translation = translate(elementText);

    if (translation) {
      if (element.nodeName === 'LABEL' && element.hasAttribute('for')) {
        const labelText = element.childNodes[0];
        labelText.textContent = translation;
      } else {
        element.textContent = translation;
      }
    }
  });
}

function toggleLanguage() {
  const languageToggle = document.getElementById('language-toggle');
  const currentLanguage = languageToggle.textContent.trim();
  const targetLanguage = currentLanguage === 'EN' ? 'CN' : 'EN';
  console.log(targetLanguage);

  languageToggle.textContent = targetLanguage;
  localStorage.setItem('selectedLanguage', targetLanguage);
  applyLanguage(targetLanguage);
}

document.getElementById('language-toggle').addEventListener('click', toggleLanguage);

// Событие DOMContentLoaded
document.addEventListener('DOMContentLoaded', function () {
  // Все формы загружены
  // Применить перевод страницы
  applyLanguage(selectedLanguage);
});

function initReservationTable() {
  console.log('inside initReservationTable');

  // Create columns (with titles) for datatable: id, name, address, age
  columns = [
    { "title": translate("Reservation ID"), "data": "id", "visible": true },
    { "title": translate("Check-in"), "data": "checkInDate" },
    { "title": translate("Check-out"), "data": "checkOutDate" },
    { "title": translate("Name"), "data": "name" },
    { "title": translate("Surname"), "data": "surName" },
    { "title": translate("Email"), "data": "email" },
    { "title": translate("Telephone number"), "data": "telephoneNumber" },
    { "title": translate("Adults"), "data": "numberOfAdults" },
    { "title": translate("Children"), "data": "numberOfChildren" },
    { "title": translate("Room"), "data": "room.roomNumber" }
  ];

  // Define new table with above columns
  reservationTable = $("#reservationTable").DataTable({
    "order": [[0, "asc"]],
    "columns": columns
  });
}

initReservationTable();
