package com.naver.cafe.javachobostudy.farmerkyh;

import org.json.JSONObject;
import org.json.simple.JSONArray;

public class JsonSimple {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("A", "a");
        jsonObject.put("B", "b");
        jsonObject.put("C", "c");

        JSONArray array = new JSONArray();
        array.add(jsonObject);
        array.add(jsonObject);
        array.add(jsonObject);
        System.out.println(array);
    }
}
