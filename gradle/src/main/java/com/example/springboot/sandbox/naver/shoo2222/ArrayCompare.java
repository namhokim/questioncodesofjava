package com.example.springboot.sandbox.naver.shoo2222;

import java.util.*;

public class ArrayCompare {
    public static void main(String[] args) {
        String[] a = new String[]{"AA", "BB"};
        String[] b = new String[]{"BB", "CC"};

        Map<String, Integer> result = new HashMap<>();
        for (String curr : a) {
            result.put(curr, 2);
        }
        for (String curr : b) {
            if (result.containsKey(curr)) {
                result.put(curr, 1);
            } else {
                result.put(curr, 0);
            }
        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
