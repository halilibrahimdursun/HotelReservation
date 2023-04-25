package com.application.repositories;

import com.application.model.Reservation;
import com.application.model.Sequence;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {
    private List<Reservation> articles = new ArrayList<>();

    public ReservationRepositoryImpl() {
        Reservation article1 = new Reservation("bike2000", "Electrical bike for sporty people", 3823.54D, "this is a picture".getBytes(), 12);
        article1.setId(Sequence.getNextSequence());
        Reservation article2 = new Reservation("bike4650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 3);
        article2.setId(Sequence.getNextSequence());
        Reservation article3 = new Reservation("bike7650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 2);
        article3.setId(Sequence.getNextSequence());
        Reservation article4 = new Reservation("bike1245", "Economy bike", 1234.99D, "this is a picture os a cheap bike".getBytes(), 2);
        article4.setId(Sequence.getNextSequence());
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
    }

    @Override
    public List<Reservation> findAll() {
        return articles;
    }

    @Override
    public Reservation findById(long id) {
        for (Reservation article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    @Override
    public Reservation save(Reservation article) {
        long id = Sequence.getNextSequence();
        article.setId(id);
        articles.add(article);

        return article;
    }

    @Override
    public void remove(long id) {
        List<Reservation> newArticles = new ArrayList<>();
        for (Reservation article : articles) {
            if (article.getId() != id) newArticles.add(article);
        }
        articles = newArticles;
    }


}
