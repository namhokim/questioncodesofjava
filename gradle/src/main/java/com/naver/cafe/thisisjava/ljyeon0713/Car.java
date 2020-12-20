package com.naver.cafe.thisisjava.ljyeon0713;

public class Car {
    int speed;

    Car() {
        speed = 0;
    }

    void method() {
        speed = 10;
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.speed = 20;
    }
}
