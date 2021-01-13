package com.naver.cafe.thisisjava.guen5997;

public class GenericMethodTest {
    public <T extends CharSequence> void printFirstChar(T parameter) {
        System.out.println(parameter.charAt(0));
    }

    public static void main(String[] args) {
        GenericMethodTest test = new GenericMethodTest();

        String ofString = "ABC";
        test.printFirstChar(ofString);

        StringBuilder ofStringBuilder = new StringBuilder();
        ofStringBuilder.append('1');
        ofStringBuilder.append('2');
        ofStringBuilder.append('3');
        test.printFirstChar(ofStringBuilder);
    }
}
