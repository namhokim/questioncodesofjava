package com.example.springboot.sandbox.naver.goharrm.innerexception;

public class InnerException {
    public class MyException extends RuntimeException {
        MyException(String message) {
            super(message);
        }
    }

    private void handleException() {
        try {
            foo();
        } catch (MyException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void foo() {
        throw new MyException("why?");
    }

    public static void main(String[] args) {
        InnerException innerException = new InnerException();
        innerException.handleException();
    }
}
