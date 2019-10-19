package com.naver.cafe.javachobostudy.hongji3354;

public class MathEx2 {
    public static void main(String[] args) {
        int i = Integer.MIN_VALUE;  // 10000000 00000000 00000000 00000000

        System.out.println("i = " + i);
        System.out.println("-i = " + (-i));

        try {
            System.out.printf("negateExact(%d) = %d%n", 10, Math.negateExact(10));
            System.out.printf("negateExact(%d) = %d%n", -10, Math.negateExact(-10));
            System.out.printf("negateExact(%d) = %d%n", i, Math.negateExact(i));
        } catch (ArithmeticException ex) {
            System.out.printf("negateExact2(%d) = %d%n", (long)i, Math.negateExact((long)i));
        }
    }
}
