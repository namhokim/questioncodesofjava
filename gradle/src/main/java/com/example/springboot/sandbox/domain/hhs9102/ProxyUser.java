package com.example.springboot.sandbox.domain.hhs9102;

public class ProxyUser {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean isProxyUserByAnnotation() {
        return this instanceof ProxyUser;
    }
}
