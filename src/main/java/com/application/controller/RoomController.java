package com.application.controller;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.RoomRepository;
import com.application.service.ReservationService;
import com.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    RoomService roomService;
    @Autowired
    RoomRepository roomRepository;

    // Endpoint
    // http://localhost:8080/api/room
    // GET
    @GetMapping (value = "room/{roomId}/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Room> findRoomById(@PathVariable long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(room.get());
        }
    }
    // Endpoint
    // http://localhost:8080/api/room
    // GET
    @GetMapping (value = "roomqqqq", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Room> findAllqqqqq(@PathVariable long roomId){
        Iterable<Room> room = roomRepository.findAllById(Collections.singleton(roomId));
        if (room.iterator().hasNext()) {
            return ResponseEntity.ok().body((Room) room);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
        // Endpoint
        // http://localhost:8080/api/room
        // GET
        @GetMapping (value = "room", produces = "application/json")
        public ResponseEntity<Iterable<Room>> findAll(){


           return ResponseEntity.ok().body(roomService.findAll());


        }

    }
