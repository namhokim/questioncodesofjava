package com.example.springboot.sandbox.me.stream;

import java.util.stream.IntStream;

public class SumOfOneToOneHundred {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 100).reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
