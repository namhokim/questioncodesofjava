package com.example.springboot.sandbox.naver.adj42589;

public class Member {
    String name;
    String id;
    String password;
    int age;

    Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

    Member(String name, String password, String id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    Member(String name, String password, String id, int age) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.age = age;
    }
}