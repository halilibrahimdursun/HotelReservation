package com.application.service;

import com.application.model.Reservation;
import com.fasterxml.jackson.annotation.OptBoolean;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Iterable<Reservation> findAll();
    Optional<Reservation> findById(long id);
    Reservation save(Reservation reservation);
    void remove( long id);
    Iterable<Reservation> filterReservationForVegan(Reservation reservation);

    Iterable<Reservation> findAllFiltered(Reservation reservation);


    Iterable<Reservation> findReservationByCheckOutDateBeforeAndCheckInDateAfter(Date checkInDate, Date checkOutDate);

}
