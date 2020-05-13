package com.naver.cafe.javachobostudy.jin78237;

import java.util.stream.IntStream;

public class MaxFrequencyRandom {

    private static final int SIZE_OF_RANGE = 10;

    public static void main(String[] args) {
        int[] counts = new int[SIZE_OF_RANGE];

        for (int i = 0; i < 100; i++) {
            int generatedNumber = (int) (Math.random() * SIZE_OF_RANGE) + 1;
            counts[generatedNumber - 1]++;
        }

        System.out.print("정수:");
        IntStream.rangeClosed(1, SIZE_OF_RANGE).forEach(x -> System.out.printf(" %d", x));
        System.out.println();

        int maxFreqNumber = 0;
        int maxFreqCount = counts[0];
        System.out.print("발생횟수:");
        for (int i = 0; i < SIZE_OF_RANGE; i++) {
            int count = counts[i];

            System.out.print(' ');
            System.out.print(count);
            if (count > maxFreqCount) {
                maxFreqNumber = i;
                maxFreqCount = count;
            }
        }
        System.out.println();

        System.out.printf("정수: %d, 횟수: %d%n", maxFreqNumber + 1, maxFreqCount);
    }
}
