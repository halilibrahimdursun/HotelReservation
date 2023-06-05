package com.application.controller;

import com.application.model.Room;
import com.application.service.RoomService;
import com.application.service.RoomServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    RoomService roomService;
    @Autowired
    RoomServiceImpl roomServiceimpl;

    protected static final Logger logger = LogManager.getLogger(RoomController.class);


    // Endpoint
    // http://localhost:8080/api/room
    // GET
    @GetMapping(value = "room/{roomId}/", consumes = "application/json", produces = "application/json")
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

    @GetMapping(value = "rooms", consumes = "application/json", produces = "application/json")
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
    // http://localhost:8080/api/room
    // GET

//    @PostMapping(value = "/room/available")
//    public ResponseEntity<List<Room>> getAvailableRooms(@RequestBody Room room,
//                                                           // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                                                            @JsonFormat(pattern="yyyy-MM-dd")
//                                                             Date startDate,
//                                                       // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                                                        @JsonFormat(pattern="yyyy-MM-dd")
//                                                            Date endDate
//)
//
//    //@RequestBody final Room room
//    //@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//    //@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
//
//
//    {
//
//        logger.info("Inside 'saveReservation'");
//        Room room = new Room();
//        room.setDisabled(isDisabled);
//        room.setCapacityOfAdults(capacityOfAdults);
//        room.setCapacityOfChildren(capacityOfChildren);
//        room.setSmoking(isSmoking);
////room.setCleaned(true);
//
//        //  List<Room> rooms = roomService.findAllFiltered(room, avelibalview.startDate, avelibalview.endDate);
//        List<Room> rooms = roomServiceimpl.findAllFiltered(room, startDate,endDate);
//        return ResponseEntity.ok().body(rooms);
//
//    }
//
//    private static class Avelibalview {
//
//
//    }


    @PostMapping(value = "/room/available", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Room>> getAvailableRooms(
            @RequestBody final Room room,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate
    ) {

        logger.info("Inside 'saveReservation'");

        List<Room> rooms = roomService.findAllFiltered(room, startDate, endDate);

        return ResponseEntity.ok(rooms) ;

    }


}
