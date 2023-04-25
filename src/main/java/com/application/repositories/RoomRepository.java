package com.application.repositories;

import com.application.model.Room;

import java.util.List;

public interface RoomRepository {

    List<Room> findAll();
}
