package com.example.springboot.sandbox.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<String, User> {
    @Override
    public User convert(String source) {
        User user = new User();
        user.setUserId(Integer.parseInt(source));
        return user;
    }
}
