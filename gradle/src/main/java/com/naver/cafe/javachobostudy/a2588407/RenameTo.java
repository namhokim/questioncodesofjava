package com.naver.cafe.javachobostudy.a2588407;

import java.io.File;

public class RenameTo {
    public static void main(String[] args) {
        File f = new File("/Users/namo/Desktop/test.txt");
        File f2 = new File("/Users/namo/Desktop/test2.txt");

        System.out.printf("%s %s%n", f.getName(), f.exists());
        System.out.printf("%s %s%n", f2.getName(), f2.exists());

        System.out.println(f.renameTo(f2));  //true

        System.out.printf("%s %s%n", f.getName(), f.exists());
        System.out.printf("%s %s%n", f2.getName(), f2.exists());
    }
}
