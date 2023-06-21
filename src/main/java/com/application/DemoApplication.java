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

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.ReservationRepository;
import com.application.repositories.RoomRepository;
import com.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

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
//		Room room = new Room(true, 200.0, "Single", 1, 0, 1, "single",false,"Coffie", "img", true, 200 );
		Reservation reservation1 = new Reservation(new Date(123, 5, 7), new Date(123, 5, 21), "John", "Wick", "john.wick@htm.com", "9876543212", 2, 1, roomRepository.findByRoomNumber(102));
		Reservation reservation2 = new Reservation(new Date(123, 5, 19), new Date(123, 5, 21), "Mary", "Billy", "mary.billy@htm.com", "1234567890", 1, 1, roomRepository.findByRoomNumber(108));
		Reservation reservation3 = new Reservation(new Date(123, 5, 15), new Date(123, 5, 23), "Kim", "Yong", "kim.cold@htm.com", "8796859432", 3, 1, roomRepository.findByRoomNumber(201));
		roomRepository.findByRoomNumber(102).setCleaned(false);
		roomRepository.findByRoomNumber(108).setCleaned(false);
		roomRepository.findByRoomNumber(201).setCleaned(false);
//		reservation.setId(1);
//		reservation.setCheckInDate(new Date(123, 5, 7));
//		reservation.setCheckOutDate(new Date(123, 5, 8));
//		reservation.setName("John");
//		reservation.setSurName("Wick");
//		reservation.setEmail("john.wick@gmail.com");
//		reservation.setTelephoneNumber("1234567890");
//		reservation.setNumberOfAdults(1);
//		reservation.setNumberOfChildren(0);
//		reservation.setRoom(roomRepository.findByRoomNumber(101));

		reservationRepository.save(reservation1);
		reservationRepository.save(reservation2);
		reservationRepository.save(reservation3);

//		room.setCleaned(true); // Пример: установите свойство cleaned на основе данных из формы
		room.setDisabled(false); // Пример: установите свойство disabled на основе данных из формы
	}
}
