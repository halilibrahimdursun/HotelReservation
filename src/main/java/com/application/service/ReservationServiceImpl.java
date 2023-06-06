package com.application.service;

import com.application.model.Reservation;
import com.application.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;


//    @Autowired
//    RoomServiceImpl roomServiceImpl;


    @Override
    public Iterable<Reservation> findAll() {
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
        return reservationRepository.findReservationByCheckOutDateBeforeAndCheckInDateAfter(checkInDate, checkOutDate);

    }




   /* public static Room roomCheck(long id){
        List<Room> rooms = new ArrayList<>();
        for (Room room : rooms);
        if()



    }
*/
}
