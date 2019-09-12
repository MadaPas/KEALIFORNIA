package com.kea.jymp.demo.controllers;

import com.kea.jymp.demo.models.Room;
import com.kea.jymp.demo.models.RoomType;
import com.kea.jymp.demo.repositories.RoomRepo;
import com.kea.jymp.demo.repositories.RoomTypeRepo;
import com.kea.jymp.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomTypeController {

    @Autowired
    RoomTypeRepo roomTypeRepo;
    @Autowired
    RoomService roomService;

    // Get all roomtypes
    @GetMapping("/api/roomtypes")
    @ResponseBody
    public List<RoomType> findAll() {
        List<RoomType> rooms = roomTypeRepo.findAll();
        return rooms;

    }

    // Add one roomtype
    @PostMapping("/api/roomtypes")
    @ResponseBody
    public int addOne(@RequestBody RoomType newRoomType){
        return roomTypeRepo.addOne(newRoomType);
    }

    // Get one roomtype
    @GetMapping("/api/roomtypes/{id}")
    @ResponseBody
    public RoomType findOne(@PathVariable int id) {
        RoomType rooms = roomTypeRepo.findOne(id);
        return rooms;
    }


    @GetMapping("/api/rooms/from/{sDate}/to/{eDate}/with/{noOfGuests}")
    @ResponseBody
    public List<RoomType> findRoomTypeWithNoOfGuests(@PathVariable String sDate, @PathVariable String eDate, @PathVariable int noOfGuests){
        return roomService.findRoomTypesWithNoOfGuests(sDate, eDate, noOfGuests);
    }

    @DeleteMapping("/api/roomtypes/{id}")
    @ResponseBody
    public void deleteOne(@PathVariable int id) {
        roomTypeRepo.deleteOne(id);
    }

    // Update one roomtype
    @PutMapping("/api/roomtypes/{id}")
    @ResponseBody
    public void updateOne(@PathVariable int id, @RequestBody RoomType roomTypeToUpdate){
        roomTypeRepo.updateOne(id, roomTypeToUpdate);
    }

}
