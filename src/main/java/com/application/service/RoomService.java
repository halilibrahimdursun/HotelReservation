package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomService {

    Iterable<Room> findAll();
    Optional<Room> findById(long id);
    Room save(Room room);
    void remove( long id);
    //public Iterable<Room> findAllFiltered(Room room);

    public List<Room> findAllFiltered(Room criteria, LocalDate startDate, LocalDate endDate);
}
