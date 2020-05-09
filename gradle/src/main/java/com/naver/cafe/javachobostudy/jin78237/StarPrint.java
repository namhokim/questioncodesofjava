package com.naver.cafe.javachobostudy.jin78237;

public class StarPrint {
    public static void main(String[] args) {
        int i,j;
        for(i=0; i<7; i++) {
            for(j=0; j<=i; j++) {
                System.out.printf("%d", j);
            }
            System.out.println();
        }
    }
}
