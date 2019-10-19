package com.naver.cafe.javachobostudy.jwan0510;

import org.springframework.stereotype.Service;

@Service
public class TestByConstructorInject {
    TestService testService;

    public TestByConstructorInject(TestService testService) {
        testService.print();
    }
}