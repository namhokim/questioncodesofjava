package com.example.springboot.sandbox.naver.jwan0510;

import org.springframework.stereotype.Service;

@Service
public class TestByConstructorInject {
    TestService testService;

    public TestByConstructorInject(TestService testService) {
        testService.print();
    }
}