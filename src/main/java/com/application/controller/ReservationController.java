package com.application.controller;

import com.application.model.Reservation;
import com.application.service.ReservationService;
import com.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //======================
    @GetMapping("/receptionist")
    public String viewReceptionistPage(Model model) {
        model.addAttribute("listReservations", reservationService.getAllReservations());
        return "receptionist";
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
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get Reservation from the service
        Reservation reservation =reservationService.getReservationById(id);

        // set Reservation as a model attribute to pre-populate the form
        model.addAttribute("reservation", reservation);
        return "update_reservation";
    }

    @GetMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable(value = "id") long id) {

        // call delete Reservation method
        this.reservationService.deleteReservationById(id);
        return "redirect:/";
    }

}
