package com.kea.jymp.demo.controllers;

import com.kea.jymp.demo.models.Room;
import com.kea.jymp.demo.repositories.RoomRepo;
import com.kea.jymp.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    RoomRepo roomRepo;
    @Autowired
    RoomService roomService;

    // Get all bookings
    @GetMapping("/api/rooms")
    @ResponseBody
    public List<Room> findAll() {
        List<Room> rooms = roomRepo.findAll();
        return rooms;
    } // Get one bookings
    @GetMapping("/api/rooms/{id}")
    @ResponseBody
    public Room findOne(@PathVariable int id) {
        Room room = roomService.populateRoomInfo(roomRepo.findOne(id));
        return room;
    }

}
