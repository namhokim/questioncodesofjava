package com.naver.cafe.javachobostudy.bogki1030;

public class LinkedListImplement {
    public static void main(String[] args) {
        Jdk1_2LinkedList ll = new Jdk1_2LinkedList();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("d");
        ll.add("e");
        for (Object o : ll) {
            System.out.println(o);
        }
    }
}
