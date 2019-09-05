package com.kea.jymp.demo.controllers;

import com.kea.jymp.demo.models.Booking;
import com.kea.jymp.demo.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // Add one booking
    @PostMapping("/api/bookings")
    @ResponseBody
    public int addOne(@RequestBody Booking newBooking){
        return bookingRepo.addOne(newBooking);
    }

    // Get one bookings
    @GetMapping("/api/bookings/{id}")
    @ResponseBody
    public Booking findOne(@PathVariable int id) {
        return bookingRepo.findOne(id);
    }

    // Delete one booking
    @DeleteMapping("/api/bookings/{id}")
    @ResponseBody
    public void deleteOne(@PathVariable int id) {
        bookingRepo.deleteOne(id);
    }

    // Update one booking
    @PutMapping("/api/bookings/{id}")
    @ResponseBody
    public void updateOne(@PathVariable int id, @RequestBody Booking bookingToUpdate) {
        bookingRepo.updateOne(id, bookingToUpdate);
    }

}
