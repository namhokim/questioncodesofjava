package com.naver.cafe.javachobostudy.laniakea33;

public class GenericReifiable {
    static class Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int capacity = 10;
//        Entry<String, String>[] table =  new Entry<String, String>[capacity];
        Entry<String, String>[] table =  new Entry[capacity];
        System.out.println(table.length);
    }
}
