package com.naver.cafe.javachobostudy.anwls1634;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FindPrimes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two integers larger than 1: : ");

        while (true) {
            try {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int i;
                int c, d;
                if (a > b) {
                    d = a;
                    c = b;

                } else {
                    c = a;
                    d = b;
                }
                for (i = c; i <= d; i++) {
                    if (isPrime(i))
                        System.out.print("Primes between [" + (int) c + ", " + (int) d + "] = "+i+", ");
                }
            } catch (InputMismatchException ime) {
                sc = new Scanner(System.in);
                System.out.println("Wrong input values!");
                System.out.print("Enter two integers larger than 1: ");
            } catch (NumberFormatException nfe) {
                sc = new Scanner(System.in);
                System.out.println("Wrong input values!");
                System.out.print("Enter two integers larger than 1: ");
            }

        }
    }

    static boolean isPrime(int n) {
        int i;

        if (n == 1)
            return false;

        for (i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
