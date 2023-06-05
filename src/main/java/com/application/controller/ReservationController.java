package com.application.controller;

import com.application.model.Reservation;
import com.application.service.ReservationService;
import com.application.service.ReservationServiceImpl;
import com.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    RoomService roomService;

    // Endpoint
    // http://localhost:8080/api/reservation
    // POST
    @PostMapping(value = "reservation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){

        return ResponseEntity.ok().body(reservationService.save(reservation));

    }

    // Endpoint
    // http://localhost:8080/api/reservation
    // GET
    @GetMapping(value = "reservation", produces = "application/json")
    public Iterable<Reservation> getAllReservations(){
        return reservationService.findAll();

    }

    // Endpoint
    // http://localhost:8080/api/reservation/filter/true
    // GET
    @PostMapping(value = "reservation/filter", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Iterable<Reservation>> getAllReservationsOnDate(@RequestBody Reservation reservation){
        return ResponseEntity.ok().body(
                reservationService.filterReservationForVegan( reservation));
    }

    // Endpoint
    // http://localhost:8080/api/reservation/2
    // GET
    @GetMapping(value = "reservation/{id}", produces = "application/json")
    public ResponseEntity<Reservation> getReservationById(@PathVariable long id){
        Optional<Reservation> reservation = reservationService.findById(id);
        return reservation.isPresent()?ResponseEntity.ok().body(reservation.get()):ResponseEntity.notFound().build();

    }

    // Endpoint
    // http://localhost:8080/api/reservation/2
    // DEL
    @DeleteMapping("reservation/{id}")
    public ResponseEntity<Void> deleteReservationById( @PathVariable long id){

        reservationService.remove(id);
        return ResponseEntity.ok().build();
    }

}