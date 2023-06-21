package com.application.controller;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.service.ReservationService;
import com.application.service.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){

        logger.info("Inside 'saveReservation'");

        Room room = roomService.findByRoomNumber( reservation.getRoom().getRoomNumber());
        room.setCleaned(false);
        reservation.setRoom(room);
        reservationService.save(reservation);
        return ResponseEntity.ok(reservation) ;
    }

    // Endpoint
    // http://localhost:8080/api/reservation
    // GET
    @GetMapping(value = "reservation", produces = "application/json")
    public Iterable<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    // Endpoint
    // http://localhost:8080/api/reservation/2
    // GET
    @GetMapping(value = "reservation/{id}", produces = "application/json")
    public ResponseEntity<Reservation> getReservationById(@PathVariable long id){
        Optional<Reservation> reservation = reservationService.findById(id);
        return reservation.isPresent()?ResponseEntity.ok().body(reservation.get()):ResponseEntity.notFound().build();
    }


    @PutMapping(value = "/totally", consumes = "application/json")
    public ResponseEntity<Double> totally(
            @RequestBody final Room room,
            @RequestParam("checkInDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkInDate,
            @RequestParam("checkOutDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOutDate) {
        Room selectedroom = roomService.findByRoomNumber(room.getRoomNumber());
        double totally = reservationService.counter(checkInDate, checkOutDate, selectedroom);
        return ResponseEntity.ok(totally);
    }

    @GetMapping(value = "/reservationincluded", produces = "application/json")
    public ResponseEntity<Iterable<Reservation>> getReservationsIncluded(
            @RequestParam("checkInDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkInDate,
            @RequestParam("checkOutDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkOutDate) {
        try {
            Iterable<Reservation> reservations = reservationService.findReservationByCheckOutDateBeforeAndCheckInDateAfter(checkInDate, checkOutDate);
            return ResponseEntity.ok( reservations);
        }
        catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }
    }


    // Endpoint
    // http://localhost:8080/api/reservation/2
    // DEL
    @DeleteMapping("reservation/{id}")
    public ResponseEntity<Void> deleteReservationById( @PathVariable long id){
        reservationService.remove(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/receptionist")
    public String viewReceptionistPage(Model model) {
        model.addAttribute("listReservations", reservationService.getAllReservations());
        return "receptionist";
    }

    @GetMapping("/amountofpayback/{id}")
    public ResponseEntity<String> calculateCancellationPolicy(@PathVariable long id) {
        Optional<Reservation> reservation = reservationService.findById(id);
        reservationService.calculateCancellationPolicy(reservation);
        return new ResponseEntity<>(reservation.get().getCancellationPolicy(), HttpStatus.OK);
    }
}