package com.kea.jymp.demo.controllers;

import com.kea.jymp.demo.models.Room;
import com.kea.jymp.demo.repositories.RoomRepo;
import com.kea.jymp.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    RoomRepo roomRepo;
    @Autowired
    RoomService roomService;

    // Get all rooms
    @GetMapping("/api/rooms")
    @ResponseBody
    public List<Room> findAll() {
        List<Room> rooms = roomRepo.findAll();
        return rooms;
    }

    // Add one room
    @PostMapping("/api/rooms")
    @ResponseBody
    public int addOne(@RequestBody Room newRoom){
        return roomRepo.addOne(newRoom);
    }

    // Find rooms available within given period
    @GetMapping("/api/rooms/from/{date1}/to/{date2}")
    @ResponseBody
    public List<Room> findBetweenDates(@PathVariable(name = "date1") String sDate, @PathVariable(name = "date2") String eDate){

        return roomService.getRoomsWithinPeriod(sDate, eDate);

    }

    // Get one room
    @GetMapping("/api/rooms/{id}")
    @ResponseBody
    public Room findOne(@PathVariable int id) {
        Room room = roomService.populateRoomInfo(roomRepo.findOne(id));
        return room;
    }

    // Update one room
    @PutMapping("/api/rooms/{id}")
    @ResponseBody
    public void updateOne(@PathVariable int id, @RequestBody Room roomToUpdate) {
        roomRepo.updateOne(id, roomToUpdate);
    }

    // Delete one room
    @DeleteMapping("/api/rooms/{id}")
    @ResponseBody
    public void deleteOne(int id){
        roomRepo.deleteOne(id);
    }



}
