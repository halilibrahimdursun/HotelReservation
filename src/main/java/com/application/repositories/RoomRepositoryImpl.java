package com.application.repositories;

import com.application.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    private List<Room> rooms = new ArrayList<>();

    @Override
    public List<Room> findAll() {
        return rooms;
    }
}
