package com.example.springboot.sandbox.naver.teen6123;

public class Argv {
    public static void main(String[] args) {
        System.out.println(Argv.class.getName());
        System.out.println(Argv.class.getSimpleName());
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
