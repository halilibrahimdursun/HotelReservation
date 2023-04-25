package com.application.service;

import com.application.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAll();
    Reservation findById(long id);
    Reservation save(Reservation article);
    void remove(long id);
    List<Reservation> checkStock(int stock);
}
