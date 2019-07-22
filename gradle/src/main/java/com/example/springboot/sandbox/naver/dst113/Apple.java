package com.example.springboot.sandbox.naver.dst113;

import com.example.springboot.sandbox.model.Fruit;

public class Apple extends Fruit implements Eatable {
    private String name;

    public Apple(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        FruitBox<Apple> fruitBox = new FruitBox<>();
        fruitBox.add(new Apple("Busa"));
        System.out.println(fruitBox.get(0));
    }

    @Override
    public void eat() {
        System.out.println("I eat an apple.");
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }
}
