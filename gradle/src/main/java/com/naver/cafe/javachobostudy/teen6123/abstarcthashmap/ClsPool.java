package com.naver.cafe.javachobostudy.teen6123.abstarcthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClsPool {
    private Map<String, ABSTAC> map;

    public ClsPool() {
        this.map = new ConcurrentHashMap<>();

        map.put("cls1", new CLS1());
        map.put("cls2", new CLS2());
    }

    public ABSTAC get(String str){
        return map.get(str);
    }
}
