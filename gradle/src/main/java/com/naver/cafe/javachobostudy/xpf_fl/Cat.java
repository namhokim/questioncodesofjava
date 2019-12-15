package com.naver.cafe.javachobostudy.xpf_fl;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal {
    private final List<Food> foods = new ArrayList<>();

    public Cat(String name) {
        super(name, foods);
    }
}
