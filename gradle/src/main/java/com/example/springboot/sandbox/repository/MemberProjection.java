package com.example.springboot.sandbox.repository;

public interface MemberProjection {

    String getName();

    default String getNameDefault() {
        return null;
    }
}
