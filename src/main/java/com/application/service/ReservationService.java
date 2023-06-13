package com.application.service;

import com.application.model.Reservation;
import com.fasterxml.jackson.annotation.OptBoolean;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> getAllReservations();
    void saveReservation(Reservation reservation);
    Reservation getReservationById(long id);
    void deleteReservationById(long id);

}

    /*Iterable<Reservation> findAll();
    Optional<Reservation> findById(long id);
    Reservation save(Reservation reservation);
    void remove( long id);
    Iterable<Reservation> filterReservationForVegan(Reservation reservation);
} */