package com.naver.cafe.javachobostudy.farmerkyh;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Slf4j
public class JsonSimple {
    public static void main(String[] args) {
        String jsString = "[{\"A\":\"a\",\"B\":\"b\",\"C\":\"c\"},{\"A\":\"a\",\"B\":\"b\",\"C\":\"c\"},{\"A\":\"a\",\"B\":\"b\",\"C\":\"c\"}]";
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(jsString);
            System.out.println(jsonArray);
        } catch (ParseException | ClassCastException e) {
            log.error("JSON Parse error: {}", jsString);
        }
    }
}
