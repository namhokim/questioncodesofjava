package com.naver.cafe.javachobostudy.jameseeho;

public class Main {
    public static void main(String[] args) {
        AnotherClass anotherClass = new AnotherClass();
        final Tv intance = anotherClass.createIntance();
        System.out.println(intance.channel);
    }
}
