package com.example.springboot.sandbox.naver.shoo2222;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayCompare {
    public static void main(String[] args) {
        String[] a = new String[]{"AA", "BB"};
        String[] b = new String[]{"BB", "CC"};

        Set<String> setA = new HashSet<>(Arrays.asList(a));

        for (String curr : b) {
            if (setA.contains(curr)) {
                System.out.println(curr + " : 0");
            } else {
                System.out.println(curr + " : 1");
            }
        }

        setA.removeAll(new HashSet<>(Arrays.asList(b)));
        for (String curr : setA) {
            System.out.println(curr + " : 2");
        }
    }
}
