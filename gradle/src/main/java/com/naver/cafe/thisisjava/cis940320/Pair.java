package com.naver.cafe.thisisjava.cis940320;

public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K e1, V e2) {
        this.key = e1;
        this.value = e2;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
