package com.kea.jymp.demo.models;

public class Room {

    private int id;
    private boolean isFree;
    private int typeId;

    public Room() {
    }

    public Room(boolean isFree, int typeId) {
        this.isFree = isFree;
        this.typeId = typeId;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

}
