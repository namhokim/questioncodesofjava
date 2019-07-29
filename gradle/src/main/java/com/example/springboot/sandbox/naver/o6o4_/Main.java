package com.example.springboot.sandbox.naver.o6o4_;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7";

        StringTokenizer st = new StringTokenizer(str, ",");

        int countTokens = st.countTokens();
        System.out.println("토큰 수 : " + countTokens);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}