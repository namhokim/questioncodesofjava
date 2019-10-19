package com.naver.cafe.javachobostudy.effect132;

public class OverrideVsAutoUnboxing {
//    private static void test(Integer i) {
//        System.out.println("Boxed " + i);
//    }

    private static void test(int i) {
        System.out.println("Primitive " + i);
    }

    private static void test2(Object o) {
        System.out.println("Object " + o);
    }

    public static void main(String[] args) {
        test(new Integer(59));
    }
}