package com.naver.cafe.javachobostudy.wnckszzz;

public class InitializingFields extends Parent {

    public InitializingFields() {
        System.out.println("InitializingFields constructor");
    }

    {
        System.out.println("Initializing Block");
    }

    private int value = getValue();

    private int getValue() {
        System.out.println("Initializing Fields");
        return 1;
    }

    public static void main(String[] args) {
        InitializingFields initializingFields = new InitializingFields();
        System.out.println(initializingFields.value);
    }
}

class Parent {
    public Parent() {
        System.out.println("Parent constructor");
    }
}
