package com.naver.cafe.thisisjava.czmn;

import java.util.Comparator;

public class PersonCompareByAge implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge();
    }
}
