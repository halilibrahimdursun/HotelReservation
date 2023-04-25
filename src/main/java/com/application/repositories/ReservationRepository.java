package com.application.repositories;

import com.application.model.Reservation;

import java.util.List;

public interface ReservationRepository {
    List<Reservation> findAll();
    Reservation findById(long id);
    Reservation save(Reservation article);
    void remove(long id);
}
