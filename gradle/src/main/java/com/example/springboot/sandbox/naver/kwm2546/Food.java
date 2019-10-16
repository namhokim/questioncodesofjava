package com.example.springboot.sandbox.naver.kwm2546;

import java.util.Scanner;

public class Food {
    private int number; //앞에 번호
    private String name; //음식 종류
    private String name1; // 음식 이름
    private String unit; //단위
    private int calory; // 칼로리

    private Food(int number, String name, String name1, String unit, int calory) {
        this.number = number;
        this.name = name;
        this.name1 = name1;
        this.unit = unit;
        this.calory = calory;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //음식개수 입력
        System.out.print("음식 개수를 입력하세요: ");
        int n = scan.nextInt();
        //음식객체 생성
        Food[] food = new Food[n];
        //음식 정보 입력
        for (int i = 0; i < n; i++) {
            System.out.println("음식정보를 입력합니다.");
            System.out.print(" 수량(숫자)을 입력하세요: ");
            int number = scan.nextInt();
            System.out.print(" 이름(문자)을 입력하세요: ");
            String name = scan.next();
            System.out.print(" 이름1(문자)을 입력하세요: ");
            String name1 = scan.next();
            System.out.print(" 단위(문자)를 입력하세요: ");
            String unit = scan.next();
            System.out.print(" 칼로리(숫자)를 입력하세요: ");
            int calory = scan.nextInt();
            scan.nextLine();
            food[i] = new Food(number, name, name1, unit, calory);

        }
        if (n == 0) { // 0이 오면 종료
            System.out.print("end");
            return;
        }
        //입력된 음식 내용 출력
        for (int i = 0; i < n; i++)
            System.out.printf("[%d]%s-%s (%dkcal/%s)", food[i].number,
                    food[i].name, food[i].name1, food[i].calory, food[i].unit);
    }
}
