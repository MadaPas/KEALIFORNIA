package com.kea.jymp.demo.services;

import com.kea.jymp.demo.models.Booking;
import com.kea.jymp.demo.models.Room;
import com.kea.jymp.demo.repositories.BookingRepo;
import com.kea.jymp.demo.repositories.RoomRepo;
import com.kea.jymp.demo.repositories.RoomTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepo roomRepo;
    @Autowired
    RoomTypeRepo roomTypeRepo;
    @Autowired
    BookingRepo bookingRepo;

    public Room populateRoomInfo(Room room) {

        room.setRoomType(roomTypeRepo.findOne(room.getRoomType().getId()));
        System.out.println(room);
        return room;
    }

    public List<Room> getRoomsWithinPeriod(String sDate, String eDate){

        // Get all rooms
        List<Room> allRooms = roomRepo.findAll();

        // Get all bookings within provided time period
        List<Booking> bookingsInPeriod = bookingRepo.findBetweenDates(sDate, eDate);

        // Iterate over each booking in the given period
        for (Booking cBooking : bookingsInPeriod) {

            // For each booking in the period, go over each room in our list
            for (Room cRoom : allRooms) {

                // If the current room is the same as the room that is booked for the current booking, remove it from
                // the list of all rooms
                if(cBooking.getRoomId() == cRoom.getId()){
                    allRooms.remove(cRoom);
                }
            }
        }

        // return list that only contains rooms that are available within given time period
        return allRooms;
    }

}
