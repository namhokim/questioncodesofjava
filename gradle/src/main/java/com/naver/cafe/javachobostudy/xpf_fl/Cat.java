package com.naver.cafe.javachobostudy.xpf_fl;

import java.util.ArrayList;

public class Cat extends Animal {
    public Cat(String name) {
        super(name, new ArrayList<>());
    }

    public static void main(String[] args) {
        Cat cat = new Cat("meaw");
        cat.foods.add(new Food());
        System.out.println(cat.foods.size());
    }
}
