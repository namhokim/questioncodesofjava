package com.example.springboot.sandbox.exception;

import me.alidg.errors.annotation.ExceptionMapping;
import me.alidg.errors.annotation.ExposeAsArg;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ExceptionMapping(statusCode = BAD_REQUEST, errorCode = "user.already_exists")
public class UserAlreadyExistsException extends RuntimeException {
    @ExposeAsArg(0) private final String username;

    public UserAlreadyExistsException(String username) {
        super();
        this.username = username;
    }
}
