package com.naver.cafe.thisisjava.lej093;

import java.io.IOException;

public class practice {
    public static void main(String[] args) throws IOException {
        boolean run = true;
        int speed = 0;
        int keycode = 0;

        while(run) {
            if(keycode != 13 && keycode != 10) {

                System.out.println("--------------------");
                System.out.println("1.증속 | 2.감소 | 3.중지");
                System.out.println("--------------------");
                System.out.println("선택: ");
            }

            keycode = System.in.read();

            switch (keycode) {
                case 49:
                    speed++;
                    System.out.println("현재 속도=" + speed);
                case 50:
                    speed--;
                    System.out.println("현재 속도=" + speed);
                default:
                    run = false;
                    break;
            }
        }

        System.out.println("프로그램 종료");
    }
}
