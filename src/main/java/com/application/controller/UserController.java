package com.application.controller;

import com.application.model.Reservation;
import com.application.repositories.ReservationRepository;
import com.application.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    RoomRepository roomRepository;
    @GetMapping("reservation")
    public Iterable<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }
}
