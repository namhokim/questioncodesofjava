package com.naver.cafe.javachobostudy.hhs9102;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class AllTestPerson {
    List<Person> list1;
    List<Person> list2;

    @Before
    public void before() {
        list1 = Arrays.asList(new Person("철수", "김"), new Person("길동", "홍"));
        list2 = Arrays.asList(new Person("철수", "방"));
    }

    @Test
    public void test() {
        Map<String, List<Person>> firstNameAndPersonsMap = new HashMap<>(list1.size());
        for (Person p1 : list1) {
            List<Person> personList = firstNameAndPersonsMap.getOrDefault(p1.firstName, new ArrayList<>());
            personList.add(p1);
            firstNameAndPersonsMap.put(p1.firstName, personList);
        }

        for (Person p2 : list1) {
            if (firstNameAndPersonsMap.containsKey(p2.firstName)) {
                List<Person> personList = firstNameAndPersonsMap.get(p2.firstName);
                for (Person p1: personList) {
                    assertEquals(p1.firstName + p1.lastName, p2.firstName + p2.lastName);
                }
            }
        }
    }

    public static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return Objects.equals(firstName, person.firstName) &&
                    Objects.equals(lastName, person.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }
    }
}
