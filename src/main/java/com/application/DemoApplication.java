package com.application;
//
//import com.application.repositories.ReservationRepository;
//import com.application.repositories.RoomRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class DemoApplication implements CommandLineRunner {
//	@Autowired
//	ReservationRepository reservationRepository;
//	@Autowired
//	RoomRepository roomRepository;
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//	}
//
////		Reservation;
////		reservation = new Reservation( 3, "06-49274625", FakerUtil.getFakeEmailAddress(), 4, false, LocalDate.now());
////		reservationRepository.save(reservation);
////		reservation = new Reservation( 6, "06-83645095", FakerUtil.getFakeEmailAddress(), 2, true, LocalDate.now());
////		reservationRepository.save(reservation);
////		reservation = new Reservation( 2, "06-91029374", FakerUtil.getFakeEmailAddress(), 4, false, LocalDate.now());
////		reservationRepository.save(reservation);
////		reservation = new Reservation( 7, "06-77293550", FakerUtil.getFakeEmailAddress(), 2, true, LocalDate.now());
////		reservationRepository.save(reservation);
////		reservation = new Reservation( 5, "06-12398702", FakerUtil.getFakeEmailAddress(), 3, false, LocalDate.now());
////		reservationRepository.save(reservation);
//}
//
//

import com.application.model.Room;
import com.application.repositories.ReservationRepository;
import com.application.repositories.RoomRepository;
import com.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	RoomService roomService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Room room = new Room();
		// Установите необходимые свойства объекта Room на основе данных из формы


		room.setCleaned(true); // Пример: установите свойство cleaned на основе данных из формы
		room.setDisabled(false); // Пример: установите свойство disabled на основе данных из формы


		// Установите остальные свойства объекта Room на основе данных из формы

		// Вызовите метод roomService.findAllFiltered() для получения отфильтрованных комнат

		Iterable<Room> filteredRooms = roomService.findAllFiltered(room);

		// Обновите пользовательский интерфейс с отфильтрованными комнатами
		// Выведите отфильтрованные комнаты на веб-страницу или выполните другие необходимые действия
	}
}
