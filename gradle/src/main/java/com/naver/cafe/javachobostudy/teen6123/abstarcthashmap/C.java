package com.naver.cafe.javachobostudy.teen6123.abstarcthashmap;

public class C {
    public static void main(String[] args) {
        final ClsPool clsPool = new ClsPool();

        Runnable run = new ThreadExe(clsPool);  // 생성자 주입
        Thread t1 = new Thread(run);
        t1.start();

        ABSTAC ins = clsPool.get("cls1");
        ins.setString("AAAAA");

        System.out.println("var : " + ins.getString());
    }
}
