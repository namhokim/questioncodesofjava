package com.example.springboot.sandbox.naver.a2588407;

import java.io.File;

public class RenameTo {
    public static void main(String[] args) {
        File f = new File("/Users/namo/Desktop/test.txt");
        System.out.println(f.getName());  //test.txt 출력
        System.out.println(f.renameTo(new File("/Users/namo/Desktop/test2.txt")));  //true
        System.out.println(f.getName()); //test.txt 출력
    }
}
