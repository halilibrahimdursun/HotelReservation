package com.application.service;

import com.application.model.Room;
import com.application.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }
    @Override
    public Optional<Room> findById(long id){
        return roomRepository.findById(id);

    }
    @Override
    public Room save(Room room) {

        return roomRepository.save(room);
    }

    @Override
    public void remove(long id) {

    }

    public void filterRoom(Room room){
        List<Room> rooms = (List<Room>) roomRepository.findAll();

        Iterable<Room> filtered = rooms
                .stream()
                .filter(checkRoom -> checkRoom.isCleaned() == room.isCleaned())
                .filter(checkRoom -> checkRoom.isDisabled() == room.isDisabled())
                .filter(checkRoom -> checkRoom.isSmoking() == room.isSmoking())
                .filter(checkRoom -> checkRoom.getTypeOfRoom() == checkRoom(checkRoom))
                .toList();
    }

    private String checkRoom(Room checkRoom) {

        if (checkRoom.getCapacityOfAdults() == 1 && checkRoom.getCapacityOfChildren() == 0) {
            return "single bed";
        } else if (checkRoom.getCapacityOfAdults() == 1 && checkRoom.getCapacityOfChildren() <= 1) {
            return "single bed + children";
        } else if (checkRoom.getCapacityOfAdults() <= 2 && checkRoom.getCapacityOfChildren() == 0) {
            return "double bed";
        } else if (checkRoom.getCapacityOfAdults() <= 2 && checkRoom.getCapacityOfChildren() <= 2) {
            return "double bed or 2 x single bed + children";
        } else if (checkRoom.getCapacityOfAdults() <= 4 && checkRoom.getCapacityOfChildren() <= 2) {
            return "2 x Double bed + children";
        } else if (checkRoom.getCapacityOfAdults() <= 8 && checkRoom.getCapacityOfChildren() <= 2) {
            return "base penthouse";
        } else if (checkRoom.getCapacityOfAdults() <= 10 && checkRoom.getCapacityOfChildren() <= 2) {
            return "luxury penthouse";
        }
        return null;
    }}