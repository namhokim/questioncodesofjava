package com.naver.cafe.thisisjava.czmn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Animal {
    private String id;
    private String name;
    private int age;

    public Animal(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // getter, setter 생략
}
