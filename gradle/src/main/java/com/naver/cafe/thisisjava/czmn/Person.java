package com.naver.cafe.thisisjava.czmn;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nonnull;
import java.util.Comparator;

@Getter
@Setter
public class Person implements Comparable<Person> {
    private static Comparator<Person> comparator = Comparator.comparing(Person::getId);

    private String id;
    private String name;
    private int age;

    public static void setComparator(Comparator<Person> comparator) {
        Person.comparator = comparator;
    }

    // getter, setter 생략

    public Person(@Nonnull String id, String name, int age) {
        Preconditions.checkNotNull(id);
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(@Nonnull Person person) {
        return Person.comparator.compare(this, person);
    }
}
