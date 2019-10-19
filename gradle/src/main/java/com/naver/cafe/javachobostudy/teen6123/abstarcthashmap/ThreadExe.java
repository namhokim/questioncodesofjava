package com.naver.cafe.javachobostudy.teen6123.abstarcthashmap;

public class ThreadExe implements Runnable {

    private final ClsPool clsPool;

    public ThreadExe(ClsPool clsPool) {
        this.clsPool = clsPool;
    }

    synchronized public void run() {
        ABSTAC ins = clsPool.get("cls1");
        ins.setString("BBBBB");
    }
}
