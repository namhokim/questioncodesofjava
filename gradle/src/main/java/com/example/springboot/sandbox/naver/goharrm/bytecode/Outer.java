package com.example.springboot.sandbox.naver.goharrm.bytecode;

public class Outer {
    private int a = 1;
    private static int b = 2;

    public void method1() {
        int c = 3;
        Inner i = new Inner(this, c);
        i.method2();
    }

    class Inner {
        final int c;
        final Outer outer;

        public Inner(Outer outer, int c) {
            this.outer = outer;
            this.c = c;

        }

        public void method2() {
            System.out.println("sum: " + (outer.a + Outer.b + c));
        }
    }

    public static void main(String[] args) {
        Outer O = new Outer();
        O.method1();
    }
}
