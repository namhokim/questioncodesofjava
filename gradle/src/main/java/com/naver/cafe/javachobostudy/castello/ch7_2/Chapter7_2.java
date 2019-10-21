package com.naver.cafe.javachobostudy.castello.ch7_2;

public class Chapter7_2 {
}

class UpCasting {
    public static void main(String[] args) {
        Car car = new FireEngine();
        car.drive();
    }
}

class DownCasting {
    public static void main(String[] args) {
        Car car = new Car();
        if (car instanceof FireEngine) {
            FireEngine fireEngine = (FireEngine) new Car();  // ClassCastException
            fireEngine.drive();
        }
    }
}

class UpAndDownCasting {
    public static void main(String[] args) {
        Car car = new FireEngine();
        if (car instanceof FireEngine) {
            FireEngine fireEngine = (FireEngine) car;
            fireEngine.drive();
        }
    }
}