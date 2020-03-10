package com.naver.cafe.javachobostudy.farmerkyh;

import org.json.simple.JSONArray;

public class JsonSimple {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String jsStr= "string형 json 객체 존재";
        JSONArray array = new JSONArray();
        array.add(jsStr);
        System.out.println(array);
    }
}
