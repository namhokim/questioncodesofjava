package com.example.springboot.sandbox.naver.dst113;

import com.example.springboot.sandbox.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit & Eatable> {
    private List<T> list;

    public FruitBox() {
        this.list = new ArrayList<>();
    }

    public void add(T fruit) {
        this.list.add(fruit);
    }

    public T get(int i) {
        return this.list.get(i);
    }

    public int size() {
        return this.list.size();
    }
}
