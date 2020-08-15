package com.naver.cafe.thisisjava.czmn;

import java.util.Comparator;

// https://cafe.naver.com/thisisjava/26168
public class CompareTest {
    public static void main(String[] args) {
        Person hong = new Person("200729", "홍길동", 22);
        Person bang = new Person("211225", "김방자", 18);

        Comparator<Person> compareByAge = new PersonCompareByAge();
        int result1 = compareByAge.compare(hong, bang);
        System.out.println(result1);

        int result2 = compareByAge.compare(bang, hong);
        System.out.println(result2);

        int result3 = compareByAge.compare(hong, hong);
        System.out.println(result3);
    }
}
