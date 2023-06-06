package com.application.controller;

import com.application.model.Reservation;
import com.application.service.ReservationService;
import com.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //======================
    @GetMapping("/receptionist")
    public String viewReceptionistPage(Model model) {
        model.addAttribute("listReservations", reservationService.getAllReservations());
        return "receptionist.html";
    }

    @GetMapping("/index")
    public String showIndexPage(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "index.html";
    }

    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
        // save reservation to database
        reservationService.saveReservation(reservation);
        return "redirect:/index";
    }

}
