package com.naver.cafe.javachobostudy.dnxprbs;

public class OverridingAccessModifier {
    public static void main(String[] args) {
        Person person = new Male();
        person.walk();
    }
}

interface Person {
    void walk();
}

class Male implements Person {
    @Override
    public void walk() {
        System.out.println("Male walk");
    }
}

class Female implements Person {
    @Override
    public void walk() {
        System.out.println("Female walk");
    }
}