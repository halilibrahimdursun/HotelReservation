// Восстанавливаем выбранный язык из local Storage (если сохранен)

const selectedLanguage = localStorage.getItem('selectedLanguage');
if (selectedLanguage) {
  const languageToggle = document.getElementById('language-toggle');
  languageToggle.textContent = selectedLanguage;

  // Применяем выбранный язык при загрузке страницы
  applyLanguage(selectedLanguage);
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


function applyLanguage(language) {


//  const links = document.querySelectorAll('.nav-menu ul li a, h1, h2, h3, h4, h6, label');
const elements = document.querySelectorAll('.nav-menu ul li a, h1, h2, h3, h4, h6, label, option, span, button, td,a,p,br');
  const translations = {
    EN: {
      '首页': 'Home',
      '关于我们': 'About Us',
      '联系我们': 'Contact',
      '登录': 'Login',
      '摩尔韦诺湖度假酒店中国': 'Molveno Lake Resort China',
      '预订您的酒店': 'Booking Your Hotel',
      '入住:': 'Check In:',
            '退房': 'Check Out:',
            '成人': 'Adult:',
            '儿童：0-12岁': 'Children: (aged 0-12)',
            '吸烟:': 'Smoking:',
            '吸烟': 'Smoking',
            '禁止吸煙': 'Non Smoking',

            '残疾人设施:': 'Disabled:',
            '残疾人设施': 'Disabled',
            '非殘疾人'  :'Non Disabled',
            '查询可用性': 'Check Availability',
            '莫爾韋諾 是該地區領先的酒店。 我們熱衷於旅行和休閒。 我們每天接待數百名旅客。': 'Molveno is the leading hotel in the region. We are passionate about travel and leisure. Every day we accommodate hundreds of travelers.',
            '因此，在預訂完美的酒店、度假屋、度假村時，我們都能滿足您的需求。': 'So when it comes to booking the perfect hotel, vacation home, resort, we have got you covered.',
            '单人间': 'Single Room',
            '每晚220美元起': 'from 220$/Per night',
            '容纳人数：最多2人': 'Capacity: Max person 2',
            '床位：单人床': 'Bed: Single Bed',
            '设施：迷你冰箱，电视，空调，无线网络，卫生间，淋浴，电话，热水壶': 'Services: mini fridge, TV, Airco, WIFI, toilet, shower, phone, water boiler',
            '双人间': 'Double Room',
            '每晚220美元起': 'from 220$/Per night',
            '容纳人数：最多4人': 'Capacity: Max person 4',
            '床位：2张单人床或1张双人床': 'Bed: 2 Single Bed or 1 Double',
            '设施：厨房，电视，空调，无线网络，卫生间，淋浴，电话，热水壶...': 'Services: Kitchen, TV, Airco, WIFI, toilet, shower, phone, water boiler...',
            '家庭间': 'Family Room',
            '每晚550美元起': 'from 550$/Per night',
            '容纳人数：最多6人': 'Capacity: Max person 6',
            '床位：2张大床，1张单人床，1张婴儿床': 'Bed: 2 Double bed, 1 Single bed, 1 Baby bed',
            '设施：迷你冰箱，电视，空调，无线网络，卫生间，淋浴+浴缸，电话...': 'Services: mini fridge, TV, Airco, WIFI, toilet, shower + bathtub, phone...',
            '顶层公寓': 'Penthouse',
            '每晚800美元起': 'from 800$/Per night',
            '容纳人数：最多10人': 'Capacity: Max person 10',
            '床位：3张大床，4张单人床，2张婴儿床': 'Bed: 3 Double, 4 singles, 2 baby beds',
            '设施：迷你冰箱，电视，空调，无线网络，卫生间，淋浴+浴缸，咖啡机...': 'Services: mini fridge, TV, Airco, WIFI, toilet, shower + bathtub, coffee machine...',
            '我们的服务': 'Our Services',
            '住宿': 'Accommodation',
            '餐饮': 'Dining',
            '水疗和健康': 'Spa & Wellness',
            '运动和娱乐': 'Sports & Recreation',
            '活动和会议': 'Events & Conferences',
            '交通': 'Transportation',
            '客户见证': 'Testimonials',
            '聯繫我們': 'Contact Us',
            '家政': 'Housekeeping',
            '水上運動和船/獨木舟租賃' : 'Water Sports and Boat/Canoe Rental',
            '雙人間': 'Double room',
            '可用房間':'Available Rooms',
            '雙倍的' :'Double',
            '單身的': 'Single',
            '2x雙':'2xDouble',
            '/每晚':'/Per night',
            '孩子們':'Children:',
            '床：':'Bed:',
            '2單人':'2 Single',
            '2 雙人間、1 間單人間、1 間嬰兒':'2 Double, 1 Single, 1 Baby',
            '不':'No',
            '選擇房間':'Select room',
            '房間':'Rooms',
            '容量':'Capacity:',
            '最多人數 6':'Max person 6',
            '最多人數 10':'Max person 10',
            '最多人數 4':'Max person 4',
            '最多人數 2':'Max person 2',
            '單人床':'Single Bed',
            '服務：':'Services:',
            '2 單人間，1 間雙人間':'2 Single, 1 Double',
            '2 雙人間、1 間單人間、1 間嬰兒':'2 Double, 1 Single, 1 Baby',
            '3 雙人間、4 間單人間、2 間嬰兒':'3 Double, 4 Single, 2 Baby',
            '迷你冰箱、電視、空調、無線上網、廁所、淋浴、電話、開水器':'mini fridge, TV, Airco, WIFI, toilet, shower, phone, water boiler',
            '廚房、電視、空調、WIFI、廁所、淋浴、電話、開水器...':'Kitchen, TV, Airco, WIFI, toilet, shower, phone, water boiler...',
            '迷你冰箱、電視、空調、無線網絡、衛生間、淋浴 + 浴缸、電話...':'mini fridge, TV, Airco, WIFI, toilet, shower + bathtub, phone...',
            '迷你冰箱、電視、空調、無線網絡、衛生間、淋浴 + 浴缸、咖啡機...':'mini fridge, TV, Airco, WIFI, toilet, shower + bathtub, coffee machine...',
            '這包括一系列配備豪華設施的客房、套房和別墅，例如舒適的床上用品、高速互聯網接入、純平電視和迷你吧':'This includes a range of guest rooms, suites, and villas with luxurious amenities such as comfortable bedding, high-speed internet access, flat-screen TVs, and minibars',
            '酒店可能有多種用餐選擇，包括高級餐廳、休閒咖啡廳、酒吧和 24 小時客房服務。':'The hotel may have several dining options, including a fine dining restaurant, a casual cafe, a bar, and 24-hour room service.',
            '這包括設備齊全的健身中心、水療中心以及瑜伽和冥想等健康項目':'This includes a fully-equipped fitness center, spa, and wellness programs such as yoga and meditation',
            '酒店可能提供机场接送、班车服务和租车服务，以方便客人出行。':'The hotel may offer airport transfers, shuttle services, and car rentals to make it easy for guests to get around.',
            '酒店礼宾团队可以帮助客人安排旅行、观光、餐厅预订和其他活动，使客人的住宿更加愉快。':'The concierge team can help guests with arranging tours, sightseeing, restaurant reservations, and other activities to make their stay more enjoyable.',
            '酒店提供每日客房服务，包括晚间整理服务和洗衣服务。':'The hotel provides daily housekeeping services, including turndown service and laundry service.',
            '酒店配有24小时安保和监控系统，以确保客人和其财物的安全。':'The hotel has 24-hour security and surveillance systems to ensure the safety of guests and their belongings.',
            '这包括配备高速互联网、视听设备和秘书服务的会议室、会议设施和商务中心。':'This includes meeting rooms, conference facilities, and business centers with access to high-speed internet, audiovisual equipment, and secretarial services.',
            '酒店可能提供各种休闲活动，包括游泳池、高尔夫球场、网球场和其他户外活动。':'The hotel may offer a range of leisure activities, including a swimming pool, golf course, tennis court, and other outdoor activities.',
            '酒店可能采取环保措施，如减少废物、使用可再生能源并在整个酒店实施可持续性实践。':'The hotel may have eco-friendly practices such as reducing waste, using renewable energy sources, and implementing sustainable practices throughout the property.',
            '酒店可能提供各种水上活动，如皮划艇、划艇、划板和机动水上运动。酒店还可能为想要探索附近湖泊或河流的客人提供船只和划艇租赁服务。':'The hotel may offer a range of water-based activities such as kayaking, canoeing, paddleboarding, and motorized water sports. The hotel may also provide boat and canoe rentals for guests who want to explore the nearby lake or river.',
            '可持续性':'Sustainability',
            '娱乐和休闲':'Entertainment and Leisure',
            '商务':'Business',
            '安全':'Security',
            '礼宾':'Concierge',
            '健康和水疗':'Wellness and Spa',
            '歡迎來到中國莫爾維諾湖度假村': 'Welcome to Molveno Lake Resort China',
            '該連鎖酒店成立於 1982 年，其願景是打造提供卓越服務和豪華住宿的世界級酒店。 經過幾十年的成功，該連鎖店已擴展到世界各地，包括中國。 該連鎖酒店的最新成員是在美麗的中國浙江省湖州市吳興區興建的酒店。 創始人王女士熱衷於創建一家能夠展示該地區自然美景的酒店，尤其是附近的太湖。': 'The hotel chain was established in 1982, with a vision to create world-class hotels that offered exceptional service and luxurious accommodations. After decades of success, the chain has expanded to various parts of the world, including China. The latest addition to the chain is the hotel being built in the beautiful Wuxing District of Huzhou, Zhejiang, China. The founder, Ms. Wang, had a passion for creating a hotel that would showcase the natural beauty of the area, particularly the nearby Taihu Lake.',
            '酒店於 2021 年開工建設，將於今年 8 月開業。 從一開始，酒店就被設計成將現代設施與中國傳統建築相結合的豪華且可持續發展的度假勝地。 酒店擁有多種客房、套房和頂層公寓，所有客房均經過精心佈置，可欣賞到周圍群山和水道的壯麗景色。 儘管是該地區的新成員，該酒店已經在旅客和行業專業人士中引起了轟動。 其對可持續發展和環保倡議的承諾贏得了各種環保組織的認可。': 'Construction of the hotel began in 2021, and it is set to open its doors in August of this year. From the outset, the hotel was designed to be a luxurious and sustainable retreat that combined modern amenities with traditional Chinese architecture. The property features a mix of guest rooms, suites, and penthouses, all carefully positioned to offer breathtaking views of the surrounding mountains and waterways. Despite being a new addition to the region, the hotel is already generating excitement among travelers and industry professionals alike. Its commitment to sustainability and eco-friendly initiatives have earned it recognition from various environmental organizations.',
            '工作人員致力於為客人提供卓越的服務，確保每次入住都令人難忘。 隨著開業在即，酒店有望成為尋求豪華和可持續度假的旅客在中國的首選目的地之一。': 'The staff is dedicated to providing exceptional service to guests, ensuring that every stay is unforgettable. With its opening just around the corner, the hotel is poised to become one of the premier destinations in China for travelers seeking a luxurious and sustainable retreat.',
            '免費每日早餐': 'Complimentary Daily Breakfast',

            '每天提供3件洗衣服务': '3 Pcs Laundry Per Day',
            '免费无线网络': 'Free Wifi',
            '平板电视': 'Flat-screen TVs',
            '迷你酒吧': 'Minibars',
            '设备齐全的健身中心': 'Fully-equipped fitness center',
            '瑜伽和冥想': 'Yoga and meditation',
            '会议设施': 'Conference facilities',
            '商务中心': 'Business centers',
            '班车服务': 'Shuttle services',
            '礼宾服务': 'Concierge services',
            '24小时安保': '24-hour security',
            '床型：':'Bed type:',
            '房間號：':'Room number:',
            '總價：':'Total price:',
            '單人房':'Single room',
            '設施：':'Facilities:',
            '姓名：':'Name:',
            '姓氏': 'Surname:',
            '电子邮件': 'Email:',
            '电话号码': 'Phone number:',
            '立即预订': 'Book now',
            '感謝預訂！':'Thanks for booking!',
            '您的預訂號碼：':'Your booking number:',
            '預訂信息將發送至您的郵箱':'Booking information will be sent to your email',
            '關閉':'Close',
            '餐廳服務': 'Restaurants Services',
            '旅行和露營': 'Travel & Camping',
            '活動與派對': 'Event & Party',
            '聯繫方式': 'Contact Info',
            '地址': 'Address:',
            '電話': 'Phone:',
            '電子郵件': 'Email:',
            '傳真': 'Fax:',
            '迷你冰箱、電視、空調、無線上網、衛生間、淋浴+浴缸、電話、開水器、咖啡機':'mini fridge, TV, Airco,WIFI, toilet, shower + bathtub, phone, water boiler, coffee machine',
            '廚房、電視、空調、無線上網、衛生間、淋浴、電話、開水器、咖啡機、桑拿、浴缸、無邊泳池、土地、遮陽傘、土地 椅子和桌子':'Kitchen, TV, Airco,WIFI, toilet, shower, phone, water boiler, coffee machine, Sauna, Bathtub, infinity swimming pool, terras, parasols, terras chairs en tables',
            '是的':'Yes',
            '迷你冰箱、電視、空調、無線上網、廁所、淋浴、電話、開水器、咖啡機':'mini fridge, TV, Airco,WIFI, toilet, shower, phone, water boiler, coffee machine',
            '找不到房間。':'No rooms found.',
            '登出':'Logout',
            '預訂 |':'Reservations |',
            '| 主頁 |':'| Homepage |',
            '經理':'manager',
            '你好':'Hello',
            '顯示': 'Show',
            '項目': 'entries',
            '搜索': 'Search:',
            '顯示中': 'Showing',
            '至': 'to',
            '的': 'of',
            '上一頁': 'Previous',
            '下一頁': 'Next',
            '編輯預訂': 'Edit Reservation',
            '取消預訂': 'Cancel Reservation',
            '創建預訂': 'Create Reservation',
            '預訂編號': 'Reservation ID',
            '入住日期': 'Check-in',
            '退房日期': 'Check-out',
            '姓名': 'Name',
            '姓氏': 'Surname',
            '電子郵件': 'Email',
            '電話號碼': 'Telephone number',
            '成人': 'Adults',
            '兒童': 'Children',
            '房間': 'Room',
            '迷你冰箱、電視、空調、WIFI、衛生間、淋浴、電話、開水器、咖啡機、桑拿、浴缸、游泳池':'Mini fridge, TV, Airco,WIFI, toilet, shower, phone, water boiler, coffee machine, Sauna, Bathtub, swimming pool',
            '2 雙人房、4 單人房、2 嬰兒房':'2 Double, 4 Single, 2 Baby'





    },
    CN: {
      'Home': '首页',
      'About Us': '关于我们',
      'Contact': '联系我们',
      'Login': '登录',
      'Molveno Lake Resort China': '摩尔韦诺湖度假酒店中国',
      'Booking Your Hotel': '预订您的酒店',
      'Check In:': '入住:',
            'Check Out:': '退房',
            'Adult:': '成人',
            'Children: (aged 0-12)': '儿童：0-12岁',
            'Smoking:': '吸烟:',
            'Smoking' :'吸烟',
            'Non Smoking':'禁止吸煙',
            'Disabled:': '残疾人设施:',
            'Disabled': '残疾人设施',
            'Non Disabled': '非殘疾人',
            'Check Availability': '查询可用性',
            'About Us': '关于我们',
            'Molveno is the leading hotel in the region. We are passionate about travel and leisure. Every day we accommodate hundreds of travelers.':'莫爾韋諾 是該地區領先的酒店。 我們熱衷於旅行和休閒。 我們每天接待數百名旅客。',
            'So when it comes to booking the perfect hotel, vacation home, resort, we have got you covered.':'因此，在預訂完美的酒店、度假屋、度假村時，我們都能滿足您的需求。',
            'Single Room': '单人间',
            'from 220$/Per night': '每晚220美元起',
            'Capacity: Max person 2': '容纳人数：最多2人',
            'Bed: Single Bed': '床位：单人床',
            'Services: mini fridge, TV, Airco, WIFI, toilet, shower, phone, water boiler': '设施：迷你冰箱，电视，空调，无线网络，卫生间，淋浴，电话，热水壶',
            'Double Room': '双人间',
            'from 220$/Per night': '每晚220美元起',
            'Capacity: Max person 4': '容纳人数：最多4人',
            'Bed: 2 Single Bed or 1 Double': '床位：2张单人床或1张双人床',
            'Services: Kitchen, TV, Airco, WIFI, toilet, shower, phone, water boiler...': '设施：厨房，电视，空调，无线网络，卫生间，淋浴，电话，热水壶...',
            'Family Room': '家庭间',
            'from 550$/Per night': '每晚550美元起',
            'Capacity: Max person 6': '容纳人数：最多6人',
            'Bed: 2 Double bed, 1 Single bed, 1 Baby bed': '床位：2张大床，1张单人床，1张婴儿床',
            'Services: mini fridge, TV, Airco, WIFI, toilet, shower + bathtub, phone...': '设施：迷你冰箱，电视，空调，无线网络，卫生间，淋浴+浴缸，电话...',
            'Penthouse': '顶层公寓',
            'from 800$/Per night': '每晚800美元起',
            'Capacity: Max person 10': '容纳人数：最多10人',
            'Bed: 3 Double, 4 singles, 2 baby beds': '床位：3张大床，4张单人床，2张婴儿床',
            'Services: mini fridge, TV, Airco, WIFI, toilet, shower + bathtub, coffee machine...': '设施：迷你冰箱，电视，空调，无线网络，卫生间，淋浴+浴缸，咖啡机...',
            'Our Services': '我们的服务',
            'Accommodation': '住宿',
            'Dining': '餐饮',
            'Spa & Wellness': '水疗和健康',
            'Sports & Recreation': '运动和娱乐',
            'Events & Conferences': '活动和会议',
            'Transportation': '交通',
            'Testimonials': '客户见证',
            'Contact Us': '聯繫我們',
            'Housekeeping': '家政',
            'Water Sports and Boat/Canoe Rental' : '水上運動和船/獨木舟租賃',
            'Double room': '雙人間',
            'Available Rooms': '可用房間',
            'Double': '雙倍的',
            'Single':'單身的',
            '2xDouble':'2x雙',
            '/Per night':'/每晚',
            'Children:':'孩子們',
            'Bed:':'床：',
            '2 Single':'2單人',
            '2 Double, 1 Single, 1 Baby':'2 雙人間、1 間單人間、1 間嬰兒',
            'No':'不',
            'Select room':'選擇房間',
            'Rooms':'房間',
            'Capacity:':'容量',
            'Max person 6':'最多人數 6',
            'Max person 10':'最多人數 10',
            'Max person 4':'最多人數 4',
            'Max person 2':'最多人數 2',
            'Single Bed':'單人床',
            'Services:':'服務：',
            '2 Single, 1 Double':'2 單人間，1 間雙人間',
            '2 Double, 1 Single, 1 Baby':'2 雙人間、1 間單人間、1 間嬰兒',
            '3 Double, 4 Single, 2 Baby':'3 雙人間、4 間單人間、2 間嬰兒',
            'mini fridge, TV, Airco,WIFI, toilet, shower, phone, water boiler':'迷你冰箱、電視、空調、無線上網、廁所、淋浴、電話、開水器',
            'Kitchen, TV, Airco,WIFI, toilet, shower, phone, water boiler...':'廚房、電視、空調、WIFI、廁所、淋浴、電話、開水器...',
            'mini fridge, TV, Airco,WIFI, toilet, shower + bathtub, phone...':'迷你冰箱、電視、空調、無線網絡、衛生間、淋浴 + 浴缸、電話...',
            'mini fridge, TV, Airco,WIFI, toilet, shower + bathtub,coffee machine...':'迷你冰箱、電視、空調、無線網絡、衛生間、淋浴 + 浴缸、咖啡機...',
            'This includes a range of guest rooms, suites, and villas with luxurious amenities such as comfortable bedding, high-speed internet access, flat-screen TVs, and minibars':'這包括一系列配備豪華設施的客房、套房和別墅，例如舒適的床上用品、高速互聯網接入、純平電視和迷你吧',
            'The hotel may have several dining options, including a fine dining restaurant, a casual cafe, a bar, and 24-hour room service.':'酒店可能有多種用餐選擇，包括高級餐廳、休閒咖啡廳、酒吧和 24 小時客房服務。',
            'This includes a fully-equipped fitness center, spa, and wellness programs such as yoga and meditation':'這包括設備齊全的健身中心、水療中心以及瑜伽和冥想等健康項目',
            'The hotel may offer airport transfers, shuttle services, and car rentals to make it easy for guests to get around': '酒店可能提供机场接送、班车服务和租车服务，以方便客人出行。',
            'The concierge team can help guests with arranging tours, sightseeing, restaurant reservations, and other activities to make their stay more enjoyable': '酒店礼宾团队可以帮助客人安排旅行、观光、餐厅预订和其他活动，使客人的住宿更加愉快。',
            'The hotel provides daily housekeeping services, including turndown service and laundry service': '酒店提供每日客房服务，包括晚间整理服务和洗衣服务。',
            'The hotel has 24-hour security and surveillance systems to ensure the safety of guests and their belongings': '酒店配有24小时安保和监控系统，以确保客人和其财物的安全。',
            'This includes meeting rooms, conference facilities, and business centers with access to high-speed internet, audiovisual equipment, and secretarial services.': '这包括配备高速互联网、视听设备和秘书服务的会议室、会议设施和商务中心。',
            'The hotel may offer a range of leisure activities, including a swimming pool, golf course, tennis court, and other outdoor activities': '酒店可能提供各种休闲活动，包括游泳池、高尔夫球场、网球场和其他户外活动。',
            'The hotel may have eco-friendly practices such as reducing waste, using renewable energy sources, and implementing sustainable practices throughout the property': '酒店可能采取环保措施，如减少废物、使用可再生能源并在整个酒店实施可持续性实践。',
            'The hotel may offer a range of water-based activities such as kayaking, canoeing, paddleboarding, and motorized water sports. The hotel may also provide boat and canoe rentals for guests who want to explore the nearby lake or river': '酒店可能提供各种水上活动，如皮划艇、划艇、划板和机动水上运动。酒店还可能为想要探索附近湖泊或河流的客人提供船只和划艇租赁服务。',
            'Sustainability': '可持续性',
            'Entertainment and Leisure': '娱乐和休闲',
            'Business': '商务',
            'Security': '安全',
            'Concierge': '礼宾',
            'Wellness and Spa': '健康和水疗',

            'Welcome to Molveno Lake Resort China':'歡迎來到中國莫爾維諾湖度假村',
            'The hotel chain was established in 1982, with a vision to create world-class hotels that offered exceptional service and luxurious accommodations. After decades of success, the chain has expanded to various parts of the world, including China. The latest addition to the chain is the hotel being built in the beautiful Wuxing District of Huzhou, Zhejiang, China. The founder, Ms. Wang, had a passion for creating a hotel that would showcase the natural beauty of the area, particularly the nearby Taihu Lake.':'該連鎖酒店成立於 1982 年，其願景是打造提供卓越服務和豪華住宿的世界級酒店。 經過幾十年的成功，該連鎖店已擴展到世界各地，包括中國。 該連鎖酒店的最新成員是在美麗的中國浙江省湖州市吳興區興建的酒店。 創始人王女士熱衷於創建一家能夠展示該地區自然美景的酒店，尤其是附近的太湖。',
            'Construction of the hotel began in 2021, and it is set to open its doors in August of this year. From the outset, the hotel was designed to be a luxurious and sustainable retreat that combined modern amenities with traditional Chinese architecture. The property features a mix of guest rooms, suites, and penthouses, all carefully positioned to offer breathtaking views of the surrounding mountains and waterways. Despite being a new addition to the region, the hotel is already generating excitement among travelers and industry professionals alike. Its commitment to sustainability and eco-friendly initiatives have earned it recognition from various environmental organizations.':'酒店於 2021 年開工建設，將於今年 8 月開業。 從一開始，酒店就被設計成將現代設施與中國傳統建築相結合的豪華且可持續發展的度假勝地。 酒店擁有多種客房、套房和頂層公寓，所有客房均經過精心佈置，可欣賞到周圍群山和水道的壯麗景色。 儘管是該地區的新成員，該酒店已經在旅客和行業專業人士中引起了轟動。 其對可持續發展和環保倡議的承諾贏得了各種環保組織的認可。',
            'The staff is dedicated to providing exceptional service to guests, ensuring that every stay is unforgettable. With its opening just around the corner, the hotel is poised to become one of the premier destinations in China for travelers seeking a luxurious and sustainable retreat.':'工作人員致力於為客人提供卓越的服務，確保每次入住都令人難忘。 隨著開業在即，酒店有望成為尋求豪華和可持續度假的旅客在中國的首選目的地之一。',
            'Complimentary Daily Breakfast':'免費每日早餐',
            '3 Pcs Laundry Per Day': '每天提供3件洗衣服务',
            'Free Wifi': '免费无线网络',
            'Flat-screen TVs': '平板电视',
            'Minibars': '迷你酒吧',
            'Fully-equipped fitness center': '设备齐全的健身中心',
            'Yoga and meditation': '瑜伽和冥想',
            'Conference facilities': '会议设施',
            'Business centers': '商务中心',
            'Shuttle services': '班车服务',
            'Concierge services': '礼宾服务',
            '24-hour security': '24小时安保',
            'Bed type:':'床型：',
            'Room number:':'房間號：',
            'Total price:':'總價：',
            'Single room':'單人房',
            'Facilities:':'設施：',
            'Name:': '姓名：',
            'Surname:': '姓氏',
            'Email:': '电子邮件',
            'Phone number:': '电话号码',
            'Book now': '立即预订',
            'Thanks for booking!':'感謝預訂！',
            'Your booking number:': '您的預訂號碼：',
            'Booking information will be sent to your email': '預訂信息將發送至您的郵箱',
            'Close': '關閉',
            'Restaurants Services':'餐廳服務',
            'Travel & Camping':'旅行和露營',
            'Event & Party':'活動與派對',
            'Contact Info':'聯繫方式',
            'Address:':'地址',
            'Phone:':'電話',
            'Email:':'電子郵件',
            'Fax:':'傳真',
            'mini fridge, TV, Airco,WIFI, toilet, shower + bathtub, phone, water boiler, coffee machine':'迷你冰箱、電視、空調、無線上網、衛生間、淋浴+浴缸、電話、開水器、咖啡機',
            'Kitchen, TV, Airco,WIFI, toilet, shower, phone, water boiler, coffee machine, Sauna, Bathtub, infinity swimming pool, terras, parasols, terras chairs en tables':'廚房、電視、空調、無線上網、衛生間、淋浴、電話、開水器、咖啡機、桑拿、浴缸、無邊泳池、土地、遮陽傘、土地 椅子和桌子',
            'Yes':'是的',
            'mini fridge, TV, Airco,WIFI, toilet, shower, phone, water boiler, coffee machine':'迷你冰箱、電視、空調、無線上網、廁所、淋浴、電話、開水器、咖啡機',
            'No rooms found.':'找不到房間。',
            'Logout': '登出',
            'Reservations |': '預訂 |',
            '| Homepage |': '| 主頁 |',
            'manager': '經理',
            'Hello': '你好',
            'Show': '顯示',
            'entries': '項目',
            'Search:': '搜索',
            'Showing': '顯示中',
            'to': '至',
            'of': '的',
            'Previous': '上一頁',
            'Next': '下一頁',
            'Edit Reservation': '編輯預訂',
            'Cancel Reservation': '取消預訂',
            'Create Reservation': '創建預訂',
            'Reservation ID': '預訂編號',
            'Check-in': '入住日期',
            'Check-out': '退房日期',
            'Name': '姓名',
            'Surname': '姓氏',
            'Email': '電子郵件',
            'Telephone number': '電話號碼',
            'Adults': '成人',
            'Children': '兒童',
            'Room': '房間',
            'Mini fridge, TV, Airco,WIFI, toilet, shower, phone, water boiler, coffee machine, Sauna, Bathtub, swimming pool':'迷你冰箱、電視、空調、WIFI、衛生間、淋浴、電話、開水器、咖啡機、桑拿、浴缸、游泳池',
            '2 Double, 4 Single, 2 Baby':'2 雙人房、4 單人房、2 嬰兒房'

    }
  };

//------------------------------

//------------------------------

  elements.forEach(function (element) {
     let elementText = element.textContent.trim();
     if (element.nodeName === 'LABEL' && element.hasAttribute('for')) {
       const forAttr = element.getAttribute('for');
       const labelText = element.childNodes[0].textContent.trim();
       elementText = `${labelText}`;
     }

     const translation = translations[language][elementText];
     console.log(elementText);

     if (translation) {
       if (element.nodeName === 'LABEL' && element.hasAttribute('for')) {
         const labelText = element.childNodes[0];
         labelText.textContent = translation;
       } else {
         element.textContent = translation;
       }
     }
   });


const serviceList = document.querySelectorAll('.ap-services li');

serviceList.forEach(function (li) {
  const iconElement = li.querySelector('.icon_check');
  if (iconElement) {
    const listItemText = iconElement.nextSibling.textContent.trim(); // Получить текст после иконки
    const translatedText = translations[language][listItemText]; // Перевести текст

    if (translatedText) {
      iconElement.nextSibling.textContent = translatedText; // Заменить текст после иконки на переведенный текст
    }
  }
});









}




document.getElementById('language-toggle').addEventListener('click', toggleLanguage);

// Событие DOMContentLoaded
document.addEventListener('DOMContentLoaded', function() {
  // Все формы загружены
  // Применить перевод страницы
  applyLanguage(selectedLanguage);
});
