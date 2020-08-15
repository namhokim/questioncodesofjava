package com.naver.cafe.thisisjava.rmm1;

public class StaticMethodPreRequirement {
    public static void main(String[] args) {
        StaticMethodPreRequirement.eatBreakfast();
    }

    private static void washHand() {
        // TBD
    }

    private static void eatBreakfast() {
        washHand();
        // TBD
    }

    private static void eatLunch() {
        washHand();
        // TBD
    }

    private static void eatDinner() {
        washHand();
        // TBD
    }
}
