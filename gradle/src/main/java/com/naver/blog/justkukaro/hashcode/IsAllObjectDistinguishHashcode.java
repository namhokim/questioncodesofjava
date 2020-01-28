package com.naver.blog.justkukaro.hashcode;

import java.util.HashMap;
import java.util.Map;

public class IsAllObjectDistinguishHashcode {
    public static void main(String[] args) {
        Map<Integer, Object> objectMap = new HashMap<>();

        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE + 1L; i++) {
            Object obj = new Object();
            int hashCode = obj.hashCode();

            Object beforeObj = objectMap.get(hashCode);
            if (beforeObj != null) {
                System.out.println("Repeat " + (i - Integer.MIN_VALUE + 1L));
                System.out.println("before: " + beforeObj.hashCode());
                System.out.println("later: " + obj.hashCode());
                System.out.println("Is same: " + beforeObj == obj);
                return;
            }

            objectMap.put(hashCode, obj);
        }
    }
}
