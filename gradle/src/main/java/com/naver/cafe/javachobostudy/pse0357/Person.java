package com.naver.cafe.javachobostudy.pse0357;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        // super() 가 생략되어 있음
        this.name = name;
        this.age = age;
        System.out.println(this.info());
        System.out.println(this);
    }

    public Person(String name) {
//        this.name = name;
//        this.age = 1;
        this(name, 1);
    }

    String info() {
        return "이름 : " + name + ", 나이: " + age;
    }
}
