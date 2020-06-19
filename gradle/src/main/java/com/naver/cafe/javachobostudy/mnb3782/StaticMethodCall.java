package com.naver.cafe.javachobostudy.mnb3782;

public class StaticMethodCall {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(StaticMethodCall.add(1, 2));

        StaticMethodCall call = new StaticMethodCall();
        System.out.println(call.add(1, 2));
    }
}
