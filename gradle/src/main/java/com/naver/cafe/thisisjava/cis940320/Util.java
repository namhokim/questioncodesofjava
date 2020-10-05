package com.naver.cafe.thisisjava.cis940320;

public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        boolean key = p1.getKey().equals(p2.getKey());
        boolean value = p1.getValue().equals(p2.getValue());
        return key && value;
    }
}
