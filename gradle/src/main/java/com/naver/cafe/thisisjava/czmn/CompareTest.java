package com.naver.cafe.thisisjava.czmn;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// https://cafe.naver.com/thisisjava/26168
public class CompareTest {
    public static void main(String[] args) {
        List<Person> people = List.of( // List.of는 Java 9 이상이 필요..
                new Person("200729", "홍길동", 22),
                new Person("211225", "김방자", 18),
                new Person("020316", "아버지", 34));

        System.out.println(people);
        List<Person> peopleSortedByName = people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
        System.out.println(peopleSortedByName);
    }
}
