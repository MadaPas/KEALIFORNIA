package com.kea.jymp.demo.models;

public class Room {

    private int id;
    private RoomType roomType;
    private Hotel hotel;
    private int roomNo;

    public Room() {
    }

    public Room(int id, RoomType roomType, Hotel hotel, int roomNo) {
        this.id = id;
        this.roomType = roomType;
        this.hotel = hotel;
        this.roomNo = roomNo;
    }

    public Room(RoomType roomType, Hotel hotel, int roomNo) {
        this.roomType = roomType;
        this.hotel = hotel;
        this.roomNo = roomNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
}
