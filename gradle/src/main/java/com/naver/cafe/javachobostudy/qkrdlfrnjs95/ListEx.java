package com.naver.cafe.javachobostudy.qkrdlfrnjs95;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListEx {
    public static void main(String[] args) {
        MyList<String> list1 = new MyList<>();
        String[] strArr = {"java", "Database", "Network", "Python"};
        list1.set(strArr);
        list1.printList();
    }
}

class MyList<T> {
    List<T> values;

    MyList() {
        values = new ArrayList<>(); // 내부 구현체로 ArrayList를 사용
    }

    void set(T[] aray) {
        values.addAll(Arrays.asList(aray));
    }

    void printList() {
        System.out.println(values);
        System.out.println("--------------------------");
    }
}
