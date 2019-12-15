package com.naver.cafe.javachobostudy.newmite0;

public class PolyArgumentTest {
    public static void main(String[] args) {
        try {
            System.out.println("try...");
            System.out.println(0 / 0);
        } catch (Exception e) {
            System.out.println("catch...");
            try {
                System.out.println("2 try...");
//                return;
                System.out.println(0 / 0);
            } catch (Exception a) {
                System.out.println("2 catch...");
            } finally {
                System.out.println("2 finally...");
            }
            System.out.println("2 finally next...");
        } finally {
            System.out.println("finally...");
        }
        System.out.println("really final!!!!!!!");
    } // end of main
}
