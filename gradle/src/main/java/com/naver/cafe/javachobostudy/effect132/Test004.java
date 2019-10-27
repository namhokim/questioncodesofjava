package com.naver.cafe.javachobostudy.effect132;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Test004 {
    private static BinaryOperator<String> lc = (s1, s2) -> {
        if (s1.length() > s2.length()) {
            return s1;
        } else {
            return s2;
        }
    };

    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Adam", "BYW", "Complex", "Robot");

        String str = ls.stream().reduce("", lc);

        System.out.println(str);
    }
}
