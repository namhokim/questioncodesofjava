package com.naver.cafe.javachobostudy.auddnekt;

import java.io.FileWriter;
import java.io.IOException;

public class AutoCloseableTest {
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("./sample.txt")) {
            fw.write("방가방가");
            System.out.println("저장완료");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("./sample2.txt");
            fw.write("방가방가");
            fw.flush();
            System.out.println("저장완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
