package com.naver.cafe.javachobostudy.farmerkyh;

import org.json.simple.JSONArray;

public class JsonSimple {
    public static void main(String[] args) {
        String jsStr= "string형 json 객체 존재";
        JSONArray array = new JSONArray(jsStr);
        System.out.println(array);
    }
}
