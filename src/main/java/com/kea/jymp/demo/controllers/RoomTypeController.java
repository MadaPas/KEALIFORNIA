package com.kea.jymp.demo.controllers;

import com.kea.jymp.demo.models.Room;
import com.kea.jymp.demo.models.RoomType;
import com.kea.jymp.demo.repositories.RoomRepo;
import com.kea.jymp.demo.repositories.RoomTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoomTypeController {

    @Autowired
    RoomTypeRepo roomTypeRepo;

    // Get all roomtypes
    @GetMapping("/api/roomtypes")
    @ResponseBody
    public List<RoomType> findAll() {
        List<RoomType> rooms = roomTypeRepo.findAll();
        return rooms;

    }// Get one roomtype
    @GetMapping("/api/roomtypes/{id}")
    @ResponseBody
    public RoomType findOne(@PathVariable int id) {
        RoomType rooms = roomTypeRepo.findOne(id);
        return rooms;
    }

}
