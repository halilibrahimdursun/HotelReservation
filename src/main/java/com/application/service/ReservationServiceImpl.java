package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.ReservationRepository;
import com.application.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Optional;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepository roomRepository;


    @Override
    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation save(Reservation reservation) {

        return reservationRepository.save(reservation);
    }

    @Override
    public void remove(long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Iterable<Reservation> filterReservationForVegan(Reservation reservation) {
        return null;
    }

    @Override
    public Iterable<Reservation> findAllFiltered(Reservation reservation) {
        return null;
    }

    @Override
    public Iterable<Reservation> findReservationByCheckOutDateBeforeAndCheckInDateAfter(Date checkInDate, Date checkOutDate) {
        return reservationRepository.findReservationByCheckOutDateAfterAndCheckInDateBefore(checkInDate, checkOutDate);
    }

    /* ================Discount=============*/
    public  double counter (LocalDate checkInDate, LocalDate checkOutDate , Room  room){
        long noOfDays = ChronoUnit.DAYS.between( checkInDate,  checkOutDate);
        double result = noOfDays * room.getPrice();
        return result;
    }
}





   /* public static Room roomCheck(long id){
        List<Room> rooms = new ArrayList<>();
        for (Room room : rooms);
        if()



    }
*/
