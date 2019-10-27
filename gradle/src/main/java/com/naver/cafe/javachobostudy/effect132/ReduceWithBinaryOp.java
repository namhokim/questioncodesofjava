package com.naver.cafe.javachobostudy.effect132;

import java.util.Arrays;
import java.util.List;

public class ReduceWithBinaryOp {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Adam", "BYW", "Complex", "Robot");


        String str = "";
        for (String elem : ls) {
            if (str.length() > elem.length()) {
                str = str;
            } else {
                str = elem;
            }
        }

        System.out.println(str);
    }
}
