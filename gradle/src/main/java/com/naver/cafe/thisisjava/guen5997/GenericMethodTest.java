package com.naver.cafe.thisisjava.guen5997;

public class GenericMethodTest {
    public <T extends CharSequence> void printFirstChar(T parameter) {
        System.out.println(parameter.charAt(0));
    }

    public static void main(String[] args) {
        GenericMethodTest test = new GenericMethodTest();
        test.printFirstChar("ABCDE");
    }
}
