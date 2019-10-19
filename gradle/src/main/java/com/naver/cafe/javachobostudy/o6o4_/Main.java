package com.naver.cafe.javachobostudy.o6o4_;

public class Main {
    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7";

        String[] tokens = str.split(",");
        System.out.println("토큰 수 : " + tokens.length);
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
