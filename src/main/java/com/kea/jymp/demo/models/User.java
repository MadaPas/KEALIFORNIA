package com.kea.jymp.demo.models;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private boolean isCustomer;

    public User() {
    }

    public User(String name, String email, String password, boolean isCustomer) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isCustomer = isCustomer;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

}
