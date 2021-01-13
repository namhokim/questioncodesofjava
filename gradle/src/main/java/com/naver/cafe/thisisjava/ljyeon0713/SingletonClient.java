package com.naver.cafe.thisisjava.ljyeon0713;

public class SingletonClient {
    public static void main(String[] args) {
        final singletone instance1 = singletone.getInstance();
        singletone.singletone = null;
        final singletone instance2 = singletone.getInstance();
        System.out.println(instance1 == instance2);
    }
}
