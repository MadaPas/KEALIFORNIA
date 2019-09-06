package com.kea.jymp.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Index
    @GetMapping("/")
    public String landing(){

        System.out.println("homepage");
        return "index.html";
    }

    // Index
    @GetMapping("/index")
    public String index(){

        System.out.println("homepage");
        return "index.html";
    }

    // Contact
    @GetMapping("/contact")
    public String contact(){

        System.out.println("contact");
        return "contact.html";
    }

    // Boom rooms
    @GetMapping("/bookrooms")
    public String boomRooms(){

        System.out.println("book rooms");
        return "bookRooms.html";
    }

    // Contact
    @GetMapping("/admin")
    public String admin(){

        System.out.println("admin");
        return "admin.html";
    }

    // Manage rooms
    @GetMapping("/managerooms")
    public String manageRooms(){

        System.out.println("manage rooms");
        return "manageRooms.html";
    }

    // Manage bookings
    @GetMapping("/managebookings")
    public String manageBookings(){

        System.out.println("manage bookings");
        return "manageBookings.html";
    }



}
