package com.naver.cafe.javachobostudy.qasert;

public class LocalVar {
    public static void main(String[] args) {
        LocalVar localVar = new LocalVar();
        localVar.foo(123, 2.3);
    }

    private void foo(int param, double p2) {
        System.out.println(param + p2);
    }
}
