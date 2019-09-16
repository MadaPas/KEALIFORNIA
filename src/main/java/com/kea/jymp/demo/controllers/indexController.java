package com.kea.jymp.demo.controllers;

import com.kea.jymp.demo.models.Hotel;
import com.kea.jymp.demo.repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class indexController {

    @Autowired
    HotelRepo hotelRepo;

    @GetMapping("/api/hotels")
    @ResponseBody
    public List<Hotel> findAll() {
        List<Hotel> hotels = hotelRepo.getAllHotels();
        return hotels;
    }
}
