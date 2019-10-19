package com.naver.cafe.javachobostudy.goharrm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArraysAsList {
    public static void main(String[] args) {
        String[] num = {"1", "2", "3", "4"};

        //경우1
        List<String> list1 = new LinkedList<>();

        //경우2
        List<String> list2 = Arrays.asList(num);
    }
}
