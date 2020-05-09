package com.naver.cafe.javachobostudy.jin78237;

public class StarPrint {
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            int j = 0;
            boolean reverse = false;
            while (j >= 0) {
                System.out.print(j);
                if (j >= i) {
                    reverse = true;
                }
                if (reverse) {
                    j--;
                } else {
                    j++;
                }
            }
            System.out.println();
        }
    }
}
