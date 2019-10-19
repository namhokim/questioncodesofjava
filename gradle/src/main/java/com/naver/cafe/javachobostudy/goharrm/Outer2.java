package com.naver.cafe.javachobostudy.goharrm;

public class Outer2 {
    public int a = 1;
    public static int b = 2;

    public void method1() {
        Inner i = new Inner();
        i.method2();
    }

    class Inner {
        public void method2() {
            System.out.println("sum: " + (a + b));
        }
    }

    public static void main(String[] args) {
        Outer2 O = new Outer2();
        O.method1();
    }
}

