package com.naver.cafe.javachobostudy.jh165515;

public class Main {
    public static void main(String[] args) {
        Parent[] pArr = new Parent[2];
        Parent fc = new FirstChild();
        pArr[0] = fc;

        System.out.println(pArr);
        System.out.println(pArr[0]);
    }
}
