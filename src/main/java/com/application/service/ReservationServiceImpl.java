package com.application.service;

import com.application.model.Reservation;
import com.application.repositories.ReservationRepository;
import com.application.repositories.ReservationRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    ReservationRepository articleRepository = new ReservationRepositoryImpl();
    @Override
    public List<Reservation> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Reservation findById(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Reservation save(Reservation article) {
        return articleRepository.save(article);
    }

    @Override
    public void remove(long id) {
        articleRepository.remove(id);

    }
    @Override
    public List<Reservation> checkStock(int stock){
        List<Reservation> filteredArticles = new ArrayList<>();
        for (Reservation article: articleRepository.findAll()) {
            if (article.getStock() <= stock) filteredArticles.add(article);

        }
        return filteredArticles;
    }
}
