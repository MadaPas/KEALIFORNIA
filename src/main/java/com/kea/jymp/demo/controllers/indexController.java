package com.kea.jymp.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

    @GetMapping("/api/hotels")
    @ResponseBody
    public List<Hotel> findAll() {
        List<Hotel> hotels = hotelRepo.findAll();
        return hotels;
    }
}
