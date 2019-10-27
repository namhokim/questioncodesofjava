package com.naver.cafe.javachobostudy.effect132;

import java.util.Arrays;
import java.util.List;

public class ReduceWithBinaryOp {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Adam", "BYW", "Complex", "Robot");

        String concatenated = ls.stream().reduce("", String::concat);
        System.out.println(concatenated);
    }
}
