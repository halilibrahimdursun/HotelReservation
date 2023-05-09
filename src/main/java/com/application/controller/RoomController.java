package com.application.controller;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.service.RoomService;
import com.application.service.RoomServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    RoomService roomService = new RoomServiceImpl();
    @GetMapping(value = "room", consumes = "application/json", produces = "application/json")
    public List<Room> getRoomsForCategories( @RequestBody Room room) {
        List<Room> rooms = roomService.getRoomsForCategories( room);
        return rooms;
    }

    @GetMapping(value = "room", produces = "application/json")
    public List<Room> getRoom() {
        List<Room> rooms = roomService.findAll();
        return rooms;
    }




}
