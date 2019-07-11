package com.example.springboot.sandbox.naver.teen6123.abstarcthashmap;

import java.util.HashMap;

abstract class ABSTAC {
    static HashMap<String, ABSTAC> map = new HashMap<String, ABSTAC>();
    static
    {
        map.put("cls1", new CLS1());
        map.put("cls2", new CLS2());
    }

    public static ABSTAC get(String str){
        return map.get(str);
    }

    abstract public String getString();
    abstract public void setString(String str);
}
