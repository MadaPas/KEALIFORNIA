package com.kea.jymp.demo.models;

import java.util.Date;

public class Booking {

    private int id;
    private int roomId;
    private int userId;
    private Date startDate;
    private Date endDate;
    private int noOfGuests;

    public Booking() {
    }

    public Booking(int roomId, int userId, Date startDate, Date endDate, int noOfGuests) {
        this.roomId = roomId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfGuests = noOfGuests;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

}
