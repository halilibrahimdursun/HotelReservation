package com.application.controller;

import com.application.model.Reservation;
import com.application.service.ReservationService;
import com.application.service.ReservationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    ReservationService reservationService = new ReservationServiceImpl();

    // Endpoint
    // http://localhost:8080/api/reservation
    //    GET
    @GetMapping(value = "reservation", produces = "application/json")
    public List<Reservation> getReservation() {
        List<Reservation> reservations = reservationService.findAll();
        return reservations;
    }
    
    // Endpoint
    // http://localhost:8080/api/reservation/stock/5
    //    GET
    @GetMapping(value = "reservation/stock/{stock}", produces = "application/json")
    public List<Reservation> getAllReservationsWithLowStock(@PathVariable int stock) {
        return reservationService.checkStock(stock);
    }

    // Endpoint
    // http://localhost:8080/api/reservation/2
    //    GET
    @GetMapping(value = "reservation/{id}", produces = "application/json")
    public Reservation getReservationsById(@PathVariable long id) {
        Reservation reservation = reservationService.findById(id);
        return reservation;
    }

    // Endpoint
    // http://localhost:8080/api/reservation
    //    PUT
    @PostMapping(value = "reservation", consumes = "application/json" , produces = "application/json")
    public Reservation creatReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    // Endpoint
    // http://localhost:8080/api/article/2
    //    DEL
    @DeleteMapping("reservation/{id}")
    public void deletReservationId(@PathVariable long id) {
        reservationService.remove(id);
    }
}
