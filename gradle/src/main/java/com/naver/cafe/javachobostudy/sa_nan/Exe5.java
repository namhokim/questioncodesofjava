package com.naver.cafe.javachobostudy.sa_nan;

public class Exe5 {
    public static void main(String[] args) {
        Time t = new Time();
        t.hour = 12;
        t.minute = 34;
        t.second = 56;

        System.out.println(t.hour);
        System.out.println(t.minute);
        System.out.println(t.second);
    }
}

class Time {
    int hour;
    int minute;
    int second;
}