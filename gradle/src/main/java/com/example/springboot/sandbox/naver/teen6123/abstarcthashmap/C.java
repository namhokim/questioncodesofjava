package com.example.springboot.sandbox.naver.teen6123.abstarcthashmap;

public class C {
    public static void main(String[] args) throws Exception {
        Runnable run;
        Thread t1;
        run = new ThreadExe();
        t1 = new Thread(run);
        t1.start();

        ABSTAC ins = ABSTAC.get("cls1");
        ins.setString("AAAAA");

        System.out.println("var : " + ins.getString());
    }
}
