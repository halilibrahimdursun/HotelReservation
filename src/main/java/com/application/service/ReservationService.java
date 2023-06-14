package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public interface ReservationService {

    Iterable<Reservation> findAll();
    Optional<Reservation> findById(long id);
    Reservation save(Reservation reservation);
    void remove( long id);
    Iterable<Reservation> filterReservationForVegan(Reservation reservation);

    ResponseEntity<Reservation> calculateCancellationPolicy(Reservation reservation);

    double counter (LocalDate startDate, LocalDate endDate , Room room);

    Iterable<Reservation> findAllFiltered(Reservation reservation);

    Iterable<Reservation> findReservationByEndDateBeforeAndStartDateAfter(Date startDate, Date endDate);
}
