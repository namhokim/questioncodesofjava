package com.naver.cafe.javachobostudy.xpf_fl;

import java.util.List;

public class Animal {
    private String name;
    protected List<Food> foods;

    public Animal(String name, List<Food> foods) {
        this.name = name;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }
}
