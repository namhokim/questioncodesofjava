package com.naver.cafe.thisisjava.cis940320;

public class StringTest {
    public static void main(String[] args) {
        final String str1 = new String("자바");
        final String str2 = new String("자바");
        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str1 == str2);
    }
}
