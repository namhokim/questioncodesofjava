package com.example.springboot.sandbox.naver.lkt0520;

import java.util.Scanner;

public class A023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 1번을 입력하세요");
        int num1 = scanner.nextInt();
        System.out.println("숫자 2번을 입력하세요");
        int num2 = scanner.nextInt();
        System.out.println("연산자를 입력하세요");
        char ch = scanner.next().charAt(0);
        // 처리
        double sum = 0;
        switch (ch) {
            case '+': sum = num1 + num2; { break; }
            case '-': sum = num1 - num2; { break; }
            case '*': sum = num1 * num2; { break; }
            case '/': sum = num1 / (double)num2; { break; }
        }

        // 출력
        if (ch == '/') {
        System.out.println(num1 + ch + num2 + "=" + (double)sum);
        }
        else
        System.out.println(num1 + ch + num2 + "=" + sum);
    }
}
