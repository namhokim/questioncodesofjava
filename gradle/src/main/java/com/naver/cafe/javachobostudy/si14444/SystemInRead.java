package com.naver.cafe.javachobostudy.si14444;

import java.io.IOException;

public class SystemInRead {
    public static void main(String[] args) throws IOException {
        char ch1 = (char)System.in.read();
        char ch2 = (char)System.in.read();
        int i1 = Integer.parseInt(String.valueOf(ch1));
        int i2 = Integer.parseInt(String.valueOf(ch2));
        int result = i1 + i2 + 48;
        System.out.println(result);
    }
}
