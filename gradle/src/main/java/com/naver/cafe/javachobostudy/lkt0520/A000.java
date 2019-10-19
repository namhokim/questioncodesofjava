package com.naver.cafe.javachobostudy.lkt0520;

public class A000 {
    public static void main(String[] args) {
        int targetValue = Integer.MAX_VALUE;
        int index = findNumberOfTimes(targetValue);
        System.out.println(index + "/" + targetValue);
    }

    private static int findNumberOfTimes(int value) {
        if (value > 0) {
            return Math.multiplyExact(value, 2) - 1;
        }
        if (value < 0) {
            return Math.multiplyExact(-value, 2);
        }
        throw new IllegalArgumentException("Cannot reach 0");
    }
}
