package com.application.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    // http://localhost:8080
    @GetMapping("/")
    public String slashPage() {

        System.out.println("Inside homePage");

        return "home";
    }

//    @GetMapping("/")
//    public String redirectToIndex() {
//        return "redirect:/index.html";
//    }

    @GetMapping("/index")
    public String indexPage() {

        System.out.println("Inside homePage");

        return "redirect:/index.html";
//        return "index";
    }



    @GetMapping("/home")
    public String homePage() {

        System.out.println("Inside homePage");

        return "home";
    }

    // http://localhost:8080
    @GetMapping("/login")
    public String loginPage() {

        System.out.println("Inside loginPage");

        return "login";

    }   // http://localhost:8080





    @GetMapping("/receptionist")
    public String receptionistPage() {

        System.out.println("Inside receptionistPage");

        return "receptionist";
    }


    // http://localhost:8080/customer
    @GetMapping("/customer")
    public String customerPage() {

        System.out.println("Inside customerPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "customer";
    }

    // http://localhost:8080/customer_no_thymeleaf
    @GetMapping("/customer_no_thymeleaf")
    public String customer_no_thymeleafPage() {

        System.out.println("Inside customer_no_thymeleafPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "customer_no_thymeleaf";
    }

    // http://localhost:8080/reservation
    @GetMapping("/reservation")
    public String reservationPage() {

        System.out.println("Inside reservationPage");

        return "reservation";
    }

    // http://localhost:8080/room
    @GetMapping("/room")
    public String roomPage() {

        System.out.println("Inside roomPage");

        return "room";
    }
}






//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class MvcController {
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
//    // http://localhost:8080/reservation
//    @GetMapping("/reservation")
//    public String reservationPage() {
//
//        System.out.println("Inside reservationPage");
//
//        return "reservation";
//    }
//
//    // http://localhost:8080/contact
//    @GetMapping("/contact")
//    public String contactPage() {
//
//        System.out.println("Inside cantactPage");
//
//        return "contact";
//    }
//
//    // http://localhost:8080/blog
//    @GetMapping("/blog")
//    public String blogPage() {
//
//        System.out.println("Inside blogPage");
//
//        return "blog";
//    }
//}
