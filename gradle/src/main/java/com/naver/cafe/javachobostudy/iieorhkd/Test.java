package com.naver.cafe.javachobostudy.iieorhkd;

public class Test {
    public static void main(String[] args) {
        String obj1 = "a";
        String obj2 = "a";
        String obj3 = new String("b");

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1 == obj2);
        System.out.println(obj1 == "a");
        System.out.println(obj1 == obj3);
    }
}
