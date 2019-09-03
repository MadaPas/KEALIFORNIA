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
}
