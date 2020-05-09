package com.naver.cafe.javachobostudy.jin78237;

public class StarPrint {
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            int j;
            for (j = 0; j <= i; j++) {
                System.out.print(j);
            }
            for (j = j - 1; j > 0; ) {
                System.out.print(--j);
            }
            System.out.println();
        }
    }
}
