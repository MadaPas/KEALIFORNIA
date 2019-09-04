package com.kea.jymp.demo.controllers;

import com.kea.jymp.demo.models.Booking;
import com.kea.jymp.demo.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingRepo bookingRepo;

    // Get all bookings
    @GetMapping("/api/bookings")
    @ResponseBody
    public List<Booking> findAll() {
        List<Booking> bookings = bookingRepo.findAll();
        return bookings;
    }

}
