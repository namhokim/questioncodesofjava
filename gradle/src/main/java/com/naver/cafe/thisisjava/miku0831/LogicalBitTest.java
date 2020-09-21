package com.naver.cafe.thisisjava.miku0831;

public class LogicalBitTest {
    public static void main(String[] args) {
        int i = 156854455;   // 00001001010110010110100010110111
        String binaryRepresentation = Integer.toBinaryString(i);
        System.out.println(binaryRepresentation);

        int leftFive = 0x8000000;  //
        int leftFiveNumber = (i & leftFive) == 0 ? 0 : 1;
        System.out.println(leftFiveNumber);
    }
}
