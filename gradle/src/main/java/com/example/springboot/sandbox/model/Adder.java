package com.example.springboot.sandbox.model;

public class Adder {
    private int number;

    public Adder(int number) {
        this.number = number;
    }

    public int add(int number) {
        this.number += number;
        return this.number;
    }

    public int getNumber() {
        return number;
    }
}
