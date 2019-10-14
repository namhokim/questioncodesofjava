package com.example.springboot.sandbox.controller;

import com.example.springboot.sandbox.exception.UserAlreadyExistsException;
import com.example.springboot.sandbox.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @GetMapping("/user")
    public String user(@Valid User user) {
        throw new UserAlreadyExistsException(user.getUsername());
    }
}
