package com.naver.cafe.javachobostudy.iieorhkd;

public class test {
    public static void main(String[] args) {
        String obj1 = "a";
        String obj2 = "a";

        if (obj1.equals(obj2)) {
            System.out.println("일치");
        }

        if (obj1 == obj2) {
            System.out.println("일치");
        }

        if (obj1 == "a") {
            System.out.println("일치");
        }
    }
}
