package com.naver.cafe.javachobostudy.muk2008;

public class Break {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("for loop");
            if (i > 5) {
                System.out.println("for loop break;");
                break;
            }
        }

        int j = 0;
        while (j < 10) {
            System.out.println("while loop");
            if (j > 5) {
                System.out.println("while loop break");
                break;
            }
            j++;
        }


        switch (j) {
            default:
                System.out.println("default break");
                break;
            case 6:
                System.out.println("switch break");
                break;
        }
    }
}
