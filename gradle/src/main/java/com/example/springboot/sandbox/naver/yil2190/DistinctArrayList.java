package com.example.springboot.sandbox.naver.yil2190;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DistinctArrayList {
    public static void main(String[] args) {
        List<Person> pList = new ArrayList<>();
        pList.add(new Person("홍길동", 19));
        pList.add(new Person("홍길동", 20));
        pList.add(new Person("고길동", 34));

        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 이름을 입력하세요 : ");
        String srcName = sc.nextLine();

        for (Person person : pList) {
            if (srcName.equals(person.getName())) {
                System.out.println(person);
            }
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + '(' + age + ')';
    }
}