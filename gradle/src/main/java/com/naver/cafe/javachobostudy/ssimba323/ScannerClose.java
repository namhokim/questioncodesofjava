package com.naver.cafe.javachobostudy.ssimba323;

import java.util.Scanner;

public class ScannerClose {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (2 <= a && a <= 10000 && 2 <= b && b <= 10000 && 2 <= c && c <= 10000) {
                System.out.println((a + b) % c);
                System.out.println((a % c + b % c) % c);
                System.out.println((a * b) % c);
                System.out.println((a % c * b % c) % c);
            }
        }
    }
}
