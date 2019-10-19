package com.naver.cafe.javachobostudy.goharrm;

public class Outer {
    public int a = 1;
    public static int b = 2;

    public void method1() {
        int c = 3;
        class Inner {
            public void method2() {
                System.out.println("sum: " + (a + b + c));
            }
        }
        Inner i = new Inner();
        i.method2();
    }

    public static void main(String[] args) {
        Outer O = new Outer();
        O.method1();
    }
}

