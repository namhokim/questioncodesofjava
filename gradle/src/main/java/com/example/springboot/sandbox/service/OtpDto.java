package com.example.springboot.sandbox.service;

import lombok.Getter;

@Getter
public class OtpDto {
    private String encodedKey;
    private String url;

    private OtpDto(String encodedKey, String url) {
        this.encodedKey = encodedKey;
        this.url = url;
    }

    public static OtpDto of (String encodedKey, String url) {
        return new OtpDto(encodedKey, url);
    }
}
