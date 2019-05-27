package com.example.springboot.sandbox.ex;

public class Question {
    public static void main(String[] args) {
        Exception exception = null;
        ArithmeticException arithmeticException = new ArithmeticException();

        arithmeticException = (ArithmeticException) exception;

        System.out.println(null instanceof ArithmeticException);

        try {
            System.out.println(0 / 0);
            System.out.println("가능");
        } catch (ArithmeticException ex) {
            System.out.println("불가능");
        } catch (Exception ex) {
            System.out.println("예외" + ex.getMessage());
        }

    }
}
