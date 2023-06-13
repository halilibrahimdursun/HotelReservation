package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import com.fasterxml.jackson.annotation.OptBoolean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Iterable<Reservation> getAllReservations();
    Optional<Reservation> findById(long id);
    Reservation save(Reservation reservation);
    void remove( long id);
    Iterable<Reservation> filterReservationForVegan(Reservation reservation);

    double counter (LocalDate checkInDate, LocalDate checkOutDate , Room room);

    Iterable<Reservation> findAllFiltered(Reservation reservation);

    Iterable<Reservation> findReservationByCheckOutDateBeforeAndCheckInDateAfter(Date checkInDate, Date checkOutDate);
}