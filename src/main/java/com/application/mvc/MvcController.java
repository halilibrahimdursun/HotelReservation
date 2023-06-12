package com.application.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {
//
//    // http://localhost:8080/customer
//    @GetMapping("/")
//    public String homePage() {
//
//        System.out.println("Inside homePage");
//
//        return "home";
//    }
//
//    // http://localhost:8080/customer
//    @GetMapping("/customer")
//    public String customerPage() {
//
//        System.out.println("Inside customerPage");
//
//        // use customer for normal use
//        // use customerT for 'template' use (header, menu, footer, etc.)
//        return "customerT";
//    }
//
    // http://localhost:8080/reservation
    @GetMapping("/reservation")
    public String reservationPage() {

        System.out.println("Inside reservationPage");

        return "reservation";
    }


}
