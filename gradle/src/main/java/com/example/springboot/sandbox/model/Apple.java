package com.example.springboot.sandbox.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apple implements Fruits {
    private String color;
    private int radius;

    @Override
    public boolean isSweet() {
        return true;
    }
}
