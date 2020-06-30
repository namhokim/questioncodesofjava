package com.naver.blog.justkukaro.example;

public class MinDetermine {
    public static void main(String[] args) {
        int minResult = min(1, 2);
        System.out.println(minResult);
    }

    private static int min(int a, int b) {
        final boolean aSmallerThanB = a < b;
        return aSmallerThanB ? a : b;
    }
}
