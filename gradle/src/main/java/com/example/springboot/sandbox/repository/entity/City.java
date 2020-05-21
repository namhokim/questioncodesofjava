package com.example.springboot.sandbox.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// https://docs.spring.io/spring-boot/docs/1.2.3.RELEASE/reference/htmlsingle/#boot-features-entity-classes
@Setter
@Getter
@Entity
public class City {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    protected City() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }
}
