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
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    @Override
    public void saveReservation(Reservation reservation) {
        this.reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(long id) {
        Optional < Reservation > optional = reservationRepository.findById(id);
        Reservation reservation = null;
        if (optional.isPresent()) {
            reservation = optional.get();
        } else {
            throw new RuntimeException(" reservation not found for id :: " + id);
        }
        return reservation;
    }

    @Override
    public void deleteReservationById(long id) {
        this.reservationRepository.deleteById(id);
    }
}
