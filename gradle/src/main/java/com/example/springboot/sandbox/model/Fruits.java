package com.example.springboot.sandbox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Fruits {
    @JsonIgnore
    boolean isSweet();
}
