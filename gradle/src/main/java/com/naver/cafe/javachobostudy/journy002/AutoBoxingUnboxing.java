package com.naver.cafe.javachobostudy.journy002;

public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        Integer integer = Integer.valueOf(12345);
        int i = integer.intValue();

        System.out.println(integer);
        System.out.println(i);
    }
}
