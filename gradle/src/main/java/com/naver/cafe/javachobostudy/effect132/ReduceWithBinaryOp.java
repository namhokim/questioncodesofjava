package com.naver.cafe.javachobostudy.effect132;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceWithBinaryOp {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Adam", "BYW", "Complex", "Robot");

        String shortestString = ls.stream().reduce("", new SurviveLongString());
        System.out.println(shortestString);
    }
}

class SurviveLongString implements BinaryOperator<String> {
    @Override
    public String apply(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return s1;
        } else {
            return s2;
        }
    }
}
