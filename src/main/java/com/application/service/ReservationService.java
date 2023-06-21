package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public interface ReservationService {

    Iterable<Reservation> getAllReservations();
    Optional<Reservation> findById(long id);
    Reservation save(Reservation reservation);
    void remove( long id);
    ResponseEntity<Reservation> calculateCancellationPolicy(Optional<Reservation> reservation);
    double counter (LocalDate checkInDate, LocalDate checkOutDate , Room room);

    Iterable<Reservation> findAllFiltered(Reservation reservation);

    Iterable<Reservation> findReservationByCheckOutDateBeforeAndCheckInDateAfter(Date checkInDate, Date checkOutDate);
}