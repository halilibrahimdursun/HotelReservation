package com.application.service;

import com.application.model.Reservation;
import com.application.repositories.ReservationRepository;
import com.application.repositories.ReservationRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    ReservationRepository reservationRepositoryImpl = new ReservationRepositoryImpl();
    @Override
    public List<Reservation> findAll() {
        return reservationRepositoryImpl.findAll();

    }

    @Override
    public Reservation findById(long id) {
        return ReservationRepositoryImpl.findById(id);
    }

    @Override
    public Reservation save(Reservation article) {
        return ReservationRepositoryImpl.save(article);
    }

    @Override
    public void remove(long id) {
        ReservationRepositoryImpl.remove(id);

    }
    @Override
    public List<Reservation> checkStock(int stock){

        List<Reservation> filteredreservations = new ArrayList<>();
        for (Reservation reservation: reservationRepositoryImpl.findAll()) {
            if (reservation.getStock() <= stock) filteredreservations.add(reservation);


        }
        return filteredreservations;
    }
}
