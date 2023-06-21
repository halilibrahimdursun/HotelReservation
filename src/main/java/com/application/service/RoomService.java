package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.application.model.Room;
import java.util.Optional;

public interface RoomService {
    Iterable<Room> findAll();
    Optional<Room> findById(long id);
    Room save(Room room);
    void remove(long id);
    List<Room> findAllFiltered(Room criteria, Date checkInDate, Date checkOutDate);
    Room findByRoomNumber(int roomNumber);
    List<Room> findAllCleanedFalse();
}

