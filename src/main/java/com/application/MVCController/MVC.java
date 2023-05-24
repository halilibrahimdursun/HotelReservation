package com.application.MVCController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVC {
    @GetMapping("/")
    public String homePage() {

        System.out.println("Inside indexPage");

        return "index";
    }

    @GetMapping("/room-details")
    public String room_details() {

        System.out.println("Inside room-detailsPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "room-details";
    }


    @GetMapping("/room-double")
    public String room_double() {

        System.out.println("Inside room-doublePage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "room-double";
    }


    @GetMapping("/room-family")
    public String room_family() {

        System.out.println("Inside room-familyPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "room-family";


}


    @GetMapping("/room-penthouse")
    public String room_penthouse() {

        System.out.println("Inside room-penthousePage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "room-penthouse";


    }


    @GetMapping("/login")
    public String login () {

        System.out.println("Inside loginPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "login";


    }


    @GetMapping("/rooms")
    public String rooms () {

        System.out.println("Inside roomsPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "rooms";


    }


    @GetMapping("/blog")
    public String blog () {

        System.out.println("Inside blogPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "blog";


    }


    @GetMapping("/contact")
    public String contact () {

        System.out.println("Inside contactPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "contact";


    }


    @GetMapping("/addRoom")
    public String addRoom () {

        System.out.println("Inside addRoomPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "addRoom";


    }

    @GetMapping("/blog-details")
    public String blog_details () {

        System.out.println("Inside blogPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "blog-details";


    }



    @GetMapping("/about_us")
    public String about_us () {

        System.out.println("Inside about_usPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "about_us";


    }



    @GetMapping("/test")
    public String test () {

        System.out.println("Inside testPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "test";


    }

    @GetMapping("/roomBooking")
    public String roomBooking () {

        System.out.println("Inside roomBookingPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "roomBooking";




    }}

