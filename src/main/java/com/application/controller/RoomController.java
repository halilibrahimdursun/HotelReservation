package com.application.controller;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.service.ReservationService;
import com.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    RoomService roomService;

    // Endpoint
    // http://localhost:9091/api/room
    // GET
    @GetMapping(value = "room", produces = "application/json")
    public Iterable<Room> getAllRooms(){
        return roomService.findAll();

    }
}
