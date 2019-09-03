package com.kea.jymp.demo.models;

public class Type {

    private int id;
    private String name;
    private int capacity;
    private double price;

    public Type() {
    }

    public Type(String name, int capacity, double price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
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

}
