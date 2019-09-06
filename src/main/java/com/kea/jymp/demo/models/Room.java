package com.kea.jymp.demo.models;

public class Room {

    private int id;
    private boolean isFree;
    private RoomType roomType;

    public Room() {
    }

    public Room(boolean isFree, RoomType roomType) {
        this.isFree = isFree;
        this.roomType = roomType;
    }

    public Room(int id, boolean isFree, RoomType roomType) {
        this.id = id;
        this.isFree = isFree;
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
