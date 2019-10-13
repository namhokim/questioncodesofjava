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
        char op = scanner.next().charAt(0); // operator (연산자)라는 의미로 이름을 부여했습니다.
        double result = 0; // sum (합)이라는 의미는 연산자에 따라 달라지므로 의미가 부적합해보여 결과(result)로 이름을 바꾸었습니다.
        switch (op) {
            case '+':
                result = num1 + num2;
                break;  // { break;} 형태 제거1
            case '-':
                result = num1 - num2;
                break;  // { break;} 형태 제거2
            case '*':
                result = num1 * num2;
                break;  // { break;} 형태 제거3
            case '/':
                result = num1 / (double) num2;
                break;  // { break;} 형태 제거4
            default:    // 잘못된 연산자에 예외 추가
                throw new IllegalArgumentException(op + "는 잘못된 연산자입니다.");
        }

        // 출력
        System.out.printf("%d%c%d=%f", num1, op, num2, result); // 포맷팅된 (formatted) 출력으로 변경
    }
}
