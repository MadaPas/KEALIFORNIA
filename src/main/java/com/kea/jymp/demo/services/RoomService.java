package com.kea.jymp.demo.services;

import com.kea.jymp.demo.models.Room;
import com.kea.jymp.demo.repositories.RoomRepo;
import com.kea.jymp.demo.repositories.RoomTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    RoomRepo roomRepo;
    @Autowired
    RoomTypeRepo roomTypeRepo;

    public Room populateRoomInfo(Room room) {

        room.setRoomType(roomTypeRepo.findOne(room.getRoomType().getId()));
        System.out.println(room);
        return room;
    }

}
