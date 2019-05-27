package com.example.springboot.sandbox.naver.eggjam82;

public class Format {
    static void method1(int x, int r) { // 1000, 2
        int length = String.valueOf(x).length(); // 4
        final String format = String.format("%%2d | %%%dd\n", length);  // "%2d | %4d"
        System.out.printf(format, r, x);    // System.out.printf("%2d | %4d", r, x);
    }

    public static void main(String[] args) {
        Format.method1(1000, 1000);
    }
}
