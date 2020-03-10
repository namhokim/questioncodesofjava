package com.naver.cafe.javachobostudy.farmerkyh;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.JSONArray;

public class JsonSimple {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String jsString = "{\"A\":\"a\",\"B\":\"b\",\"C\":\"c\"}";
        JSONTokener jsonTokener = new JSONTokener(jsString);
        JSONObject jsonObject = new JSONObject(jsonTokener);

        JSONArray array = new JSONArray();
        array.add(jsonObject);
        array.add(jsonObject);
        array.add(jsonObject);
        System.out.println(array);
    }
}
