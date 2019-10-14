package com.example.springboot.sandbox.naver.lkt0520;

public class A000 {
    public static void main(String[] args) {
        int targetValue = 100;
        int index = findNumberOfTimes(targetValue);
        System.out.println(index + "/" + targetValue);
    }

    private static int findNumberOfTimes(int value) {
        if (value > 0) {
            return (value * 2) - 1;
        }
        if (value < 0) {
            return -value * 2;
        }
        throw new IllegalArgumentException("Cannot reach 0");
    }
}
