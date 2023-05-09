package com.application.service;

import com.application.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getRoomsForCategories(Room room);

    List<Room> findAll();
}
