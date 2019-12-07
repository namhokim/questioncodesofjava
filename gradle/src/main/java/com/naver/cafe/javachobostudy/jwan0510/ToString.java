package com.naver.cafe.javachobostudy.jwan0510;

import org.springframework.util.StopWatch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ToString {
    public static void main(String[] args) {
        final List<Object> somethings = IntStream.range(0, 10000000)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
        //List<Object> somethings = List.of("abc", "def", "gef");
        StopWatch stopWatch = new StopWatch("performance");
        stopWatch.start();
        int lastLength = 0;
        for (Object some:somethings) {
            //String str = some.toString();   // 41ms 49ms
            String str = (String)some;  // 41ms, 39ms
            lastLength = str.length();
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(lastLength);
    }
}
