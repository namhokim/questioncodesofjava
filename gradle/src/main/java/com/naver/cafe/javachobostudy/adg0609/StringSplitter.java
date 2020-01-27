package com.naver.cafe.javachobostudy.adg0609;

import java.util.Arrays;

public class StringSplitter {
    private StringSplitter() {}

    public static int[] splitNumbers(String text) {
        String[] tokens = text.split("[\\[,\\]]");
        return Arrays.stream(tokens)
                .filter(value -> !value.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
