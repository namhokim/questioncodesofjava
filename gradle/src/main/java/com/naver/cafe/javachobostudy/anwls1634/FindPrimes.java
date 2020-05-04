package com.naver.cafe.javachobostudy.anwls1634;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FindPrimes {

    private static final String INPUT_MESSAGE = "Enter two integers greater than 1: ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(INPUT_MESSAGE);
            try {
                int a = sc.nextInt();
                int b = sc.nextInt();

                printPrimesBetween(a, b);
            } catch (InputMismatchException | NumberFormatException ime) {
                sc = new Scanner(System.in);
                System.out.println("Wrong input values!");
                System.out.print(INPUT_MESSAGE);
            }
        }
    }

    static void printPrimesBetween(int from, int to) {
        int lower = Math.min(from, to);
        int higher = Math.max(from, to);
        boolean hasBeforePrimeNumber = false;

        System.out.print("Primes between [" + lower + ", " + higher + "] = ");
        for (int i = lower; i <= higher; i++) {
            if (isPrime(i)) {
                if (hasBeforePrimeNumber) {
                    System.out.print(", ");
                }
                System.out.print(i);
                hasBeforePrimeNumber = true;
            }
        }
        System.out.println();
    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
