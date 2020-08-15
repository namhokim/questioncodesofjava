package com.naver.cafe.thisisjava.nineteenvalen;

public class ForSumFrom1To100Example3 {
    public static void main(String[] args) {
        int sum = 0;
        int i;
        for(i=1; i<=100; i++) {
            sum += i;
        }
        System.out.println("1~" + (i-1) + "합: " + sum);
    }
}
