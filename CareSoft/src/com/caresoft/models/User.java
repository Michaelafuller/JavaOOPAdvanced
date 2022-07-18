package com.caresoft.models;

public class User {

    protected Integer id;
    protected int pin;


    // getters
    public int getPin() {
        return pin;
    }

    public Integer getId() {
        return id;
    }

    // setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
