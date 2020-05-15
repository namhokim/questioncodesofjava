package com.naver.cafe.javachobostudy.jameseeho;

public class Tv {
    int channel;

    private Tv() {
        // factory method 로만 객체를 생성하도록 private 으로 생성자를 구성
    }

    public static Tv createIntance() {
        Tv tv = new Tv();
        tv.channel = 2;
        return tv;
    }
}
