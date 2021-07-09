package com.naver.cafe.isajime.heega;

public class ElementaryMath {
    public static void main(String[] args) {
        printDivisorSameRemain(248, 299);
    }

    private static void printDivisorSameRemain(int dividend1, int dividend2) {
        int upperLimit = Math.max(dividend1, dividend2);
        for (int divisor = 2; divisor < upperLimit; divisor++) {
            int remain1 = dividend1 % divisor;
            int remain2 = dividend2 % divisor;
            if (remain1 == remain2) {
                System.out.println(divisor);
            }
        }
    }
}
