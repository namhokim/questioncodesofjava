package com.naver.cafe.javachobostudy.jin78237;

public class MaxFrequencyRandom {
    public static void main(String[] args) {
        int[]no = new int[100];

        for(int i = 0 ;i<100; i++) {
            no[i] = (int) (Math.random() * 10) + 1;
        }
        for (int i = 0; i < no.length; i++) {
            System.out.printf("%4d", no[i]);
        }
    }
}
