package com.naver.cafe.javachobostudy.hhs9102;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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

    @Test
    public void test3() {
        Set<String> list2Set = new HashSet<>(list2);
        for (String str1 : list1) {
            if (list2Set.contains(str1)) {
                doSomething(str1, str1);
            }
        }
    }

    @Test
    public void test4() {
        executeWhenMatchElement(list1, list2, (str) -> System.out.println(String.format("str1: %s, str2: %s", str, str)));
    }

    private void executeWhenMatchElement(List<String> list1, List<String> list2,
                                         Consumer<String> executeFunction) {
        final List<String> smaller, bigger;
        if (list1.size() < list2.size()) {
            smaller = list1;
            bigger = list2;
        } else {
            smaller = list2;
            bigger = list1;
        }

        Set<String> smallerSet = new HashSet<>(smaller);
        for (String value : bigger) {
            if (smallerSet.contains(value)) {
                executeFunction.accept(value);
            }
        }
    }

    public void doSomething(String str1, String str2) {
        System.out.println(String.format("str1: %s, str2: %s", str1, str2));
    }
}
