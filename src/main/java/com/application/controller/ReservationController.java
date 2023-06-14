package com.application.controller;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.service.ReservationService;
import com.application.service.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    RoomService roomService;

    protected static final Logger logger = LogManager.getLogger(ReservationController.class);

    // Endpoint
    // http://localhost:8080/api/reservation
    // POST
    @PostMapping(value = "reservation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
        return ResponseEntity.ok(reservation);
    }

    // Endpoint
    // http://localhost:8080/api/reservation
    // GET
    @GetMapping(value = "reservation", produces = "application/json")
    public Iterable<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    // Endpoint
    // http://localhost:8080/api/reservation/filter
    // POST
    @PostMapping(value = "reservation/filter", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Iterable<Reservation>> getAllReservationsOnDate(@RequestBody Reservation reservation) {
        return ResponseEntity.ok().body(reservationService.findAllFiltered(reservation));
    }

    // Endpoint
    // http://localhost:8080/api/reservation/{id}
    // GET
    @GetMapping(value = "reservation/{id}", produces = "application/json")
    public ResponseEntity<Reservation> getReservationById(@PathVariable long id) {
        Optional<Reservation> reservation = reservationService.findById(id);
        return reservation.isPresent() ? ResponseEntity.ok().body(reservation.get()) : ResponseEntity.notFound().build();
    }

    // Endpoint
    // http://localhost:8080/api/totallyPrice?startDate=2023-06-01&endDate=2023-06-15
    // PUT
    @PutMapping(value = "/totallyPrice", consumes = "application/json")
    public ResponseEntity<Double> calculateTotalPrice(
            @RequestBody Room room,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        double totalPrice = reservationService.counter(startDate, endDate, room);
        return ResponseEntity.ok(totalPrice);
    }

    // Endpoint
    // http://localhost:8080/api/reservationincluded?startDate=2023-06-01&endDate=2023-06-15
    // GET
    @GetMapping(value = "/reservationincluded", produces = "application/json")
    public ResponseEntity<Iterable<Reservation>> getReservationsIncluded(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        try {
            Iterable<Reservation> reservations = reservationService.findReservationByEndDateBeforeAndStartDateAfter(startDate, endDate);
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    // Endpoint
    // http://localhost:8080/api/reservation/{id}
    // DELETE
    @DeleteMapping("reservation/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable long id) {
        reservationService.remove(id);
        return ResponseEntity.ok().build();
    }

    // Endpoint
    // http://localhost:8080/api/calculateCancellationPolicy/{id}
    // GET
    @GetMapping("calculateCancellationPolicy/{id}")
    public ResponseEntity<Void> calculateCancellationPolicyById(@PathVariable long id) {
        // Add your cancellation policy logic here
        // Retrieve the reservation by ID and update the cancellation policy accordingly
        // Example: Reservation = reservationService.findById(id).orElse(null);
        // ...
        Reservation reservation = reservationService.findById(id).get();
        reservationService.calculateCancellationPolicy(reservation);
        return ResponseEntity.ok().build();
    }
}
