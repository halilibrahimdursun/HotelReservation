package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import java.util.Date;
import java.util.List;
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
//    void remove( long id);
//    //public Iterable<Room> findAllFiltered(Room room);
//
//    public List<Room> findAllFiltered(Room criteria, Date startDate, Date endDate);

    void remove(long id);
    List<Room> findAllFiltered(Room criteria, Date checkInDate, Date checkOutDate);

    Room findByRoomNumber(int roomNumber);

//    Iterable<Room> findAllFiltered(Room room);

}

