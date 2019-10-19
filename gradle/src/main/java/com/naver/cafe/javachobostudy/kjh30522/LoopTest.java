package com.naver.cafe.javachobostudy.kjh30522;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LoopTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
            list.add(Integer.toString(i));
        }

        // 1
        list.forEach(System.out::println);
        list.forEach(new PrintWithLinefeed());

        // 2
        for (String str : list) {
            System.out.println(str);
        }
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

    }
}

class PrintWithLinefeed implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}