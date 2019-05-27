package com.example.springboot.sandbox.controller;

public class User {
    private Integer userId;

    public User() {
        this.userId = null;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User(" +
                "userId=" + userId +
                ')';
    }
}
