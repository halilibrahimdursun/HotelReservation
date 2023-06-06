package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    @Override
    public void saveReservation(Reservation reservation) {
        this.reservationRepository.save(reservation);
    }


}