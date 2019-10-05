package com.example.springboot.sandbox.naver.kjh30522;

import java.util.ArrayList;
import java.util.List;

public class LoopTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i=0; i<10; i++) {
            list.add(""+i);
        }

        // 1
        list.forEach(str-> {
            System.out.println(str);
        });

        // 2
        for(String str : list) {
            System.out.println(str);
        }
    }
}
