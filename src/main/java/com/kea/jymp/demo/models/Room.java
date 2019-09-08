package com.kea.jymp.demo.models;

public class Room {

    private int id;
    private boolean isBooked;
    private RoomType roomType;

    public Room() {
    }

    public Room(boolean isBooked, RoomType roomType) {
        this.isBooked = isBooked;
        this.roomType = roomType;
    }

    public Room(int id, boolean isBooked, RoomType roomType) {
        this.id = id;
        this.isBooked = isBooked;
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
