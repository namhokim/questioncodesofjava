package com.naver.cafe.thisisjava.yeji930131;

public class ContinueKeyCodeReadExample {
    public static void main(String[] args) throws Exception {
        int keyCode;

        while (true) {      //while -> Hye
            keyCode = System.in.read();
            System.out.println("keyCode: " + keyCode);
        }
    }
}
