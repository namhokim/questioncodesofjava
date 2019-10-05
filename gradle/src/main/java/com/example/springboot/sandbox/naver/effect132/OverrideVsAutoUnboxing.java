package com.example.springboot.sandbox.naver.effect132;

public class OverrideVsAutoUnboxing {
    private void test(int i) {
        System.out.println("Primitive " + i);
    }

//    private void test(Integer i) {
//        System.out.println("Boxed " + i);
//    }

    private void test(Object o) {
        System.out.println("Object " + o);
    }

    public static void main(String[] args) {
        OverrideVsAutoUnboxing overrideVsAutoUnboxing = new OverrideVsAutoUnboxing();
        overrideVsAutoUnboxing.test(new Integer(59));
    }
}
