package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;

import java.util.Optional;

//public interface RoomService {
//
//    Iterable<Room> findAll();
//    Optional<Room> findById(long id);
//    Room save(Room room);
//    void remove( long id);
//
//    Iterable<Room> findAllFiltered(Room room);
//}


import com.application.model.Room;
        import java.util.Optional;

public interface RoomService {
    Iterable<Room> findAll();
    Optional<Room> findById(long id);
    Room save(Room room);
    void remove(long id);
    Iterable<Room> findAllFiltered(Room room);
}

