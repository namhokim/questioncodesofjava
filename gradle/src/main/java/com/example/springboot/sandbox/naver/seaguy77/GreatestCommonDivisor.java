package com.example.springboot.sandbox.naver.seaguy77;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE / 2;
        int cnt = 5;
        long total = 1;
        for (int i = 1; i <= n; i++) {
            total *= 2;   // => 이부분이 안먹음
            if (total == 0) {
                System.out.println(i);  // 64
                break;
            }
        }
        long G = gcd(total, cnt);
        System.out.println(G);
    }

    private static long gcd(long total, int cnt) {
        System.out.println(total);
        return total;
    }
}
