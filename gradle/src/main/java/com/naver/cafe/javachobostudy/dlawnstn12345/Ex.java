package com.naver.cafe.javachobostudy.dlawnstn12345;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Ex {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 100; i++) {
            Runnable run = () -> {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) exe;

                int poolsize = threadPoolExecutor.getPoolSize();
                String threadName = Thread.currentThread().getName();
                System.out.println("총 스레드 개수 : " + poolsize + ", 작업스레드 이름 : " + threadName);

                //int value = Integer.parseInt("숫자");
            };

            exe.execute(run);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        exe.shutdown();
    }
}
