package com.application.controller;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.RoomRepository;
import com.application.service.ReservationService;
import com.application.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomController {


    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
    @Autowired
    RoomService roomService;


    // Endpoint
    // http://localhost:8080/api/room
    // GET
    @GetMapping (value = "room/{roomId}/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Room> findRoomById(@PathVariable long roomId) {
        Optional<Room> room = roomService.findById(roomId);
        if (room.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(room.get());
        }
    }
    // Endpoint
    // http://localhost:8080/api/room
    // GET

    @GetMapping (value = "room", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Room> findAll(@PathVariable long roomId){
        Iterable<Room> room = roomService.findAll();
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

    // Endpoint
    // http://localhost:8080/api/room
    // GET
    @GetMapping (value = "room/filtered", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Iterable<Room>> findAllFiltered(@RequestBody Room room){
        Iterable<Room> rooms = roomService.findAllFiltered(room);

        return ResponseEntity.ok().body(rooms);


    }

    // Endpoint
    // http://localhost:8080/api/room/filtered
    // POST

    @PostMapping(value = "room/filtered", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Iterable<Room>> filterRooms(@RequestBody Room room) {


        System.out.println("Received data from form:");
        System.out.println("Adult Value: " + room.getCapacityOfAdults());
        System.out.println("Children Count: " + room.getCapacityOfChildren());
        System.out.println("Disabled: " + room.isDisabled());
        System.out.println("Smocking: " + room.isSmoking());
//         Other output to the console for data validation // Другие выводы в консоль для проверки данных

        Iterable<Room> filteredRooms = roomService.findAllFiltered(room);
        return ResponseEntity.ok().body(filteredRooms);
    }


}
