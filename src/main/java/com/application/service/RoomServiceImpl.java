package com.application.service;

import com.application.model.Room;
import com.application.repositories.RoomRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class RoomServiceImpl implements RoomService{

    RoomRepositoryImpl roomRepository = new RoomRepositoryImpl();
    @Override
    public List<Room> getRoomsForCategories(Room room) {

        List<Room> rooms = roomRepository.findAll();

        List<Room> filtered = rooms
                .stream()
                .filter(c -> c.getNumberOfAdults() == room.getNumberOfAdults())
                .filter(room1 -> room1.getNumberOfChildren() == room.getNumberOfChildren())
                .filter(room1 -> room1.getTypeOfBed() == room.getTypeOfBed())
                .filter(room1 -> room1.getSmoke() == room.getSmoke())
                .collect(Collectors.toList());

        return filtered;
    }
    @Override
    public List<Room> findAll(){
        return roomRepository.findAll();
    }

}
