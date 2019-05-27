package com.example.springboot.sandbox.naver.thdjun92;

import org.json.JSONArray;

public class StringExtract {
    public static void main(String[] args) {
        String text = "[\"abc\",\"def\"]";
        JSONArray array = new JSONArray(text);
        for (int i = 0; i < array.length(); i++) {
            final String elem = (String)array.get(i);
            System.out.println(elem);
        }
    }
}
