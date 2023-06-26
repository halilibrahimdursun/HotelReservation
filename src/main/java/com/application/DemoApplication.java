package com.application;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.ReservationRepository;
import com.application.repositories.RoomRepository;
import com.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	RoomRepository roomRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Room room = new Room();
		Reservation reservation1 = new Reservation(new Date(123, 5, 21), new Date(123, 5, 22), "1 day", "before check-in", "john.wick@htm.com", "9876543212", 2, 1, roomRepository.findByRoomNumber(102));
		Reservation reservation2 = new Reservation(new Date(123, 5, 28), new Date(123, 5, 29), "7 days", "before check-in", "mary.billy@htm.com", "1234567890", 1, 1, roomRepository.findByRoomNumber(108));
		Reservation reservation3 = new Reservation(new Date(123, 6, 5), new Date(123, 6, 6), "14 days", "before check-in", "kim.cold@htm.com", "8796859432", 3, 1, roomRepository.findByRoomNumber(201));
		Reservation reservation4 = new Reservation(new Date(123, 6, 6), new Date(123, 6, 7), "15 days or more", "before check-in", "kim.cold@htm.com", "8796859432", 3, 1, roomRepository.findByRoomNumber(202));
		roomRepository.findByRoomNumber(102).setCleaned(false);
		roomRepository.findByRoomNumber(108).setCleaned(false);
		roomRepository.findByRoomNumber(201).setCleaned(false);
		roomRepository.findByRoomNumber(202).setCleaned(false);
		reservationRepository.save(reservation1);
		reservationRepository.save(reservation2);
		reservationRepository.save(reservation3);
		reservationRepository.save(reservation4);

//		room.setCleaned(true); // Пример: установите свойство cleaned на основе данных из формы
		room.setDisabled(false); // Пример: установите свойство disabled на основе данных из формы
	}
}
