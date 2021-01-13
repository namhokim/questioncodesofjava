package com.naver.cafe.thisisjava.ljyeon0713;

public class singletone {
    static singletone singletone = new singletone();

    private singletone() {
    }

    static singletone getInstance() {
        return singletone;
    }
}
