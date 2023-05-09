package com.application.repositories;

//test

import com.application.model.Reservation;
import com.application.model.Sequence;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {
    private List<Reservation> reservations = new ArrayList<>();

    public ReservationRepositoryImpl() {
        Reservation reservation1 = new Reservation("bike2000", "Electrical bike for sporty people", 3823.54D, "this is a picture".getBytes(), 12);
        reservation1.setId(Sequence.getNextSequence());
        Reservation reservation2 = new Reservation("bike4650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 3);
        reservation2.setId(Sequence.getNextSequence());
        Reservation reservation3 = new Reservation("bike7650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 2);
        reservation3.setId(Sequence.getNextSequence());
        Reservation reservation4 = new Reservation("bike1245", "Economy bike", 1234.99D, "this is a picture os a cheap bike".getBytes(), 2);
        reservation4.setId(Sequence.getNextSequence());
        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);
        reservations.add(reservation4);
    }

    @Override
    public List<Reservation> findAll() {
        return reservations;
    }

    @Override
    public Reservation findById(long id) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == id) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public Reservation save(Reservation reservation) {
        long id = Sequence.getNextSequence();
        reservation.setId(id);
        reservations.add(reservation);

        return reservation;
    }

    @Override
    public void remove(long id) {
        List<Reservation> newreservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getId() != id) newreservations.add(reservation);
        }
        reservations = newreservations;
    }


}