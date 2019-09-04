package com.kea.jymp.demo.models;

import java.time.LocalDate;
import java.util.Date;

public class Booking {

    private int id;
    private int roomId;
    private int userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int noOfGuests;

    public Booking() {
    }

    public Booking(int roomId, int userId, LocalDate startDate, LocalDate endDate, int noOfGuests) {
        this.roomId = roomId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfGuests = noOfGuests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }
}
