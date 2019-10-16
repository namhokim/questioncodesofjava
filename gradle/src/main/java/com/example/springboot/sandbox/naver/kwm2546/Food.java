package com.example.springboot.sandbox.naver.kwm2546;

import java.util.Scanner;

public class Food {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //음식갯수 입력
        System.out.print("음식: ");
        int n = scan.nextInt();
        //음식객체 생성
        Food1[] food = new Food1[n];
        //음식 정보 입력
        for(int i=0; i<n; i++) {
            System.out.print("음식정보: ");
            int number = scan.nextInt();
            String name = scan.next();
            String name1 = scan.next();
            String unit = scan.next();
            int calory = scan.nextInt();
            scan.nextLine();
            food[i] = new Food1(number,name, name1, unit, calory);

        }
        if (n == 0) { // 0이 오면 종료
            System.out.printf("end");
            return;
        }
        //입력된 음식 내용 출력
        for(int i=0; i<n; i++)
            System.out.printf("[%d]%s-%s (%dkcal/%s)", food[i].number,
                    food[i].name,food[i].name1, food[i].calory,food[i].unit);
    }
}
class Food1{
    int number; //앞에 번호
    String name; //음식 종류
    String name1; // 음식 이름
    String unit; //단위
    int calory; // 칼로리

    public Food1(int number, String name, String name1, String unit, int calory){
        this.number = number;
        this.name = name;
        this.name1 = name1;
        this.unit = unit;
        this.calory = calory;
    }


}
