package com.naver.cafe.javachobostudy.violleh468;

import org.springframework.util.StopWatch;

import java.util.function.IntConsumer;

public class DigitExtract {
    public static void main(String[] args) {
        int start = 10;
        int end = 1_000_000;
        repeat(start, end, DigitExtract::usingStringConversion);
        repeat(start, end, DigitExtract::usingIntegerDivision);
    }

    private static void repeat(int start, int end, IntConsumer consumer) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = start; i < end; i++) {
            consumer.accept(i);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    private static void usingStringConversion(int value) {
        int a = Integer.parseInt(Character.toString(Integer.toString(value).charAt(0)));
        int b = Integer.parseInt(Character.toString(Integer.toString(value).charAt(1)));
        int c = a + b;
        //System.out.printf("%d + %d%n", a, b);
    }

    private static void usingIntegerDivision(int value) {
        int a = value / 10 % 10;
        int b = value % 10;
        int c = a + b;
        //System.out.printf("%d + %d%n", a, b);
    }

}
