package com.naver.cafe.javachobostudy.xpf_fl;

import java.util.List;

public class Animal {
    private String name;
    private List<Food> foods;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, List<Food> foods) {
        this.name = name;
        this.foods = foods;
    }
}
