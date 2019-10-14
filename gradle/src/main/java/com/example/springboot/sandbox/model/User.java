package com.example.springboot.sandbox.model;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class User {
    @NotBlank(message = "username.required")
    private final String username;

    @NotBlank(message = "password.required")
    @Size(min = 6, max = 20, message = "password.length")
    private final String password;

    public User( String username, String password) {
        this.username = username;
        this.password = password;
    }
}
