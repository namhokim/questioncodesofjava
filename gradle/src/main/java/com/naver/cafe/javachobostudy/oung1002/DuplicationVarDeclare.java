package com.naver.cafe.javachobostudy.oung1002;

public class DuplicationVarDeclare {
    public static void main(String[] args) {
        int i = 100;
        byte b = (byte) i;
        System.out.println(b);

//        int i = 300;
//        byte b = (byte) i;
//        System.out.println(b);

        int k = -2;
        b = (byte) k;
        System.out.println(b);

        System.out.println(Integer.toBinaryString(k));
    }
}
