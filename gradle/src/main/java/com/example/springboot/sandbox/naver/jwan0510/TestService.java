package com.example.springboot.sandbox.naver.jwan0510;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestService() {
        System.out.println("TestService - constructor");
    }
    public void print() {
        System.out.println("TestService - print");
    }
}
