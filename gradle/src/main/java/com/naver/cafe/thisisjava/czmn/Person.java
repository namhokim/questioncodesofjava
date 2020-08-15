package com.naver.cafe.thisisjava.czmn;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nonnull;

@Getter
@Setter
public class Person implements Comparable<Animal> {
    private String id;
    private String name;
    private int age;

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
    public int compareTo(@Nonnull Animal animal) {
        return this.age - animal.getAge();
    }
}
