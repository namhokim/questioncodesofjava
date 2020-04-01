package com.naver.cafe.javachobostudy.toyongyeon;

import java.util.Arrays;
import java.util.List;

public class Generic {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = Arrays.asList(1, 2, 3, 4);
        list.add("1");
        list.get(0);
    }
}
