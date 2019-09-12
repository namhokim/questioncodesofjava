package com.example.springboot.sandbox.me.random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomSeedCollisions {
    public static void main(String[] args) throws Throwable {

        class RandomCollector implements Runnable {
            private long[] randoms = new long[1 << 16];

            public void run() {
                for (int i = 0; i < randoms.length; i++) {
                    randoms[i] = new Random().nextLong();
                }
            }
        }

        final int threadCount = 10;
        List<RandomCollector> collectors = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            RandomCollector r = new RandomCollector();
            collectors.add(r);
            threads.add(new Thread(r));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        int collisions = 0;
        HashSet<Long> s = new HashSet<>();
        for (RandomCollector r : collectors) {
            for (long x : r.randoms) {
                if (s.contains(x))
                    collisions++;
                s.add(x);
            }
        }
        System.out.printf("collisions=%d%n", collisions);
        if (collisions > 10) {
            throw new Error("too many collisions");
        }
    }
}
