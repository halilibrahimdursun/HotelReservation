package com.application.service;

import com.application.model.Reservation;
import com.application.repositories.ReservationRepository;
import com.application.repositories.ReservationRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    ReservationRepository ReservationRepositoryImpl = new ReservationRepositoryImpl();
    @Override
    public List<Reservation> findAll() {
        return ReservationRepositoryImpl.findAll();
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
        List<Reservation> filteredArticles = new ArrayList<>();
        for (Reservation article: ReservationRepositoryImpl.findAll()) {
            if (article.getStock() <= stock) filteredArticles.add(article);

        }
        return filteredArticles;
    }
}
