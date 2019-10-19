package com.naver.cafe.javachobostudy.jwan0510;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestByFieldInject {
    @Autowired
    TestService testService;

    public TestByFieldInject() {
        //testService.print();
        System.out.println("TestByFieldInject - constructor");
    }

    @PostConstruct
    public void check() {
        System.out.println("TestByFieldInject - PostConstruct");
        //testService.print();
    }
}
