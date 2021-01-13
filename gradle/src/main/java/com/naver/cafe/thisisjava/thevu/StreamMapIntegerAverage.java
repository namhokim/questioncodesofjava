package com.naver.cafe.thisisjava.thevu;

import java.util.Arrays;
import java.util.List;

public class StreamMapIntegerAverage {
    public static void main(String[] args) {
        List<String> list2 = Arrays.asList("1,2,3", "4,5,6");
        double output = list2.stream().flatMap(s-> Arrays.stream(s.split(",")))
                .map(s->Integer.parseInt(s.trim()))
                .average(); // cannot find symbol

        System.out.println(output);
    }
}
