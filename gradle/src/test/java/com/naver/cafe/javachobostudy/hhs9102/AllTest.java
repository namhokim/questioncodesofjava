package com.naver.cafe.javachobostudy.hhs9102;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class AllTest {
    List<String> list1 = Arrays.asList("a", "b", "c");
    List<String> list2 = Arrays.asList("c", "d", "e");

    @Test
    //이중 for
    public void test() {
        for (String str1 : list1) {
            for (String str2 : list2) {
                if (str1.equals(str2)) {
                    doSomething(str1, str2);
                }
            }
        }
    }

    @Test
    //Map으로 변환 후 get사용 비교
    public void test2() {
        Map<String, String> map1 = list1.stream()
                .collect(Collectors.toMap((String::toString), (String::toString)));
        Map<String, String> map2 = list2.stream()
                .collect(Collectors.toMap((String::toString), (String::toString)));

        for (Map.Entry<String, String> map1Entry : map1.entrySet()) {
            if (map2.get(map1Entry.getKey()) != null) {
                doSomething(map1Entry.getValue(), map2.get(map1Entry.getKey()));
            }
        }
    }

    public void doSomething(String str1, String str2) {
        System.out.println(String.format("str1: %s, str2: %s", str1, str2));
    }
}
