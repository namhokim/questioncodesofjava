package com.naver.cafe.javachobostudy.suprlux09;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSubList {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        l.add("e");
        l.add("f");

        System.out.println(l);

        List l2 = l.subList(1, 4);

        System.out.println(l2);

        l2.remove(1);

        System.out.println(l2);

        System.out.println(l);


    }
}
