package com.example.springboot.sandbox.naver.teen6123.abstarcthashmap;

public class ThreadExe implements Runnable {

    synchronized public void run() {
        ABSTAC ins = ABSTAC.get("cls1");
        ins.setString("BBBBB");
    }
}
