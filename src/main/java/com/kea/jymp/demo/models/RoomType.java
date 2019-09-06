package com.kea.jymp.demo.models;

public class RoomType {

    private int id;
    private String name;
    private int capacity;
    private double price;
    private String description;

    public RoomType() {
    }

    public RoomType(int id, String name, int capacity, double price, String description) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.description = description;
    }

    public RoomType(String name, int capacity, double price, String description) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
