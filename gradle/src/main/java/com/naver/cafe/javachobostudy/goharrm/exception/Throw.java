package com.naver.cafe.javachobostudy.goharrm.exception;

public class Throw {
    private static void foo() {
        RuntimeException ex = new RuntimeException("msg");
        throw ex;
    }
    public static void main(String[] args) {
        try {
            foo();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
