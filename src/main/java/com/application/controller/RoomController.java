package com.application.controller;

import com.application.model.Room;
import com.application.service.RoomService;
import com.application.service.RoomServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomController {


    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
    @Autowired
    RoomService roomService;
    @Autowired
    RoomServiceImpl roomServiceimpl;


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

    @GetMapping (value = "rooms", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Room>> findAll() {
        Iterable<Room> room = roomService.findAll();
        if (room.iterator().hasNext()) {
            //  return ResponseEntity.ok().body(List<Room>);
            return ResponseEntity.ok().body((List<Room>) room);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

        // Endpoint
        // http://localhost:8080/api/room
        // GET
//        @GetMapping (value = "room", produces = "application/json")
//        public ResponseEntity<Iterable<Room>> findAll(){
//
//           return ResponseEntity.ok().body(roomService.findAll());
//
//
//
//        }

    // Endpoint
    // http://localhost:8080/api/room/available
    // POST
//    @GetMapping (value = "room/filtered", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Iterable<Room>> findAllFiltered(@RequestBody Room room,
//        @RequestParam("checkInDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkInDate,
//        @RequestParam("checkOutDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkOutDate){
//
//        System.out.println("Received data from form:");
//        System.out.println("Adult Value: " + room.getCapacityOfAdults());
//        System.out.println("Children Count: " + room.getCapacityOfChildren());
//        System.out.println("Disabled: " + room.isDisabled());
//        System.out.println("Smocking: " + room.isSmoking());
//        logger.info("Inside 'saveReservation'");
//
//
//        Iterable<Room> rooms = roomService.findAllFiltered(room, checkInDate, checkOutDate);
//        return ResponseEntity.ok().body(rooms);
//    }

    @PostMapping(value = "/room/available", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Room>> getAvailableRooms(
            @RequestBody final Room room,
            @RequestParam("checkInDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkInDate,
            @RequestParam("checkOutDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkOutDate
    ) {
//
        System.out.println("Received data from form:");
        System.out.println("Adult Value: " + room.getCapacityOfAdults());
        System.out.println("Children Count: " + room.getCapacityOfChildren());
        System.out.println("Disabled: " + room.isDisabled());
        System.out.println("Smocking: " + room.isSmocking());
        System.out.println("Cleaned: " + room.isCleaned());
        logger.info("Inside 'saveReservation'");

        List<Room> rooms = roomService.findAllFiltered(room, checkInDate, checkOutDate);


        System.out.println("[");
        for (Room availableRoom : rooms) {
            System.out.println("    " + availableRoom.toString());
        }
        System.out.println("]");


        return ResponseEntity.ok(rooms) ;




        // Endpoint
    // http://localhost:8080/api/room/filtered
    // POST

//    @PostMapping(value = "room/filtered", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Iterable<Room>> filterRooms(@RequestBody Room room) {


//        System.out.println("Received data from form:");
//        System.out.println("Adult Value: " + room.getCapacityOfAdults());
//        System.out.println("Children Count: " + room.getCapacityOfChildren());
//        System.out.println("Disabled: " + room.isDisabled());
//        System.out.println("Smocking: " + room.isSmoking());
//         Other output to the console for data validation // Другие выводы в консоль для проверки данных
//
//        Iterable<Room> filteredRooms = roomService.findAllFiltered(room);
//        return ResponseEntity.ok().body(filteredRooms);
    }


}
