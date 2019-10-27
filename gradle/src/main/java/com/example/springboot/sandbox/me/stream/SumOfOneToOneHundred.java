package com.example.springboot.sandbox.me.stream;

import java.util.stream.IntStream;

public class SumOfOneToOneHundred {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 201).reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println(sum(1, 201));
    }

    private static int sum(int startInclusive, int endInclusive) {
        return (startInclusive + endInclusive) * (endInclusive - startInclusive + 1) / 2;
    }
}
