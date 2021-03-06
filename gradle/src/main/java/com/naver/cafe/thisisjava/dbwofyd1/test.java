package com.naver.cafe.thisisjava.dbwofyd1;

import java.io.IOException;

public class test {
	public static void main(String[] args) throws IOException {
		//값을 외부에서 받기 때문에 오류가 발생할 가능성이 높음
		//그렇기에 throws Exception(또는 IOException)을 입력하여 예외처리
		boolean run = true;
		int speed = 0;
		int keycode = 0;

		while(run) {
			System.out.println("--------------------");
			System.out.println("1.증속 | 2.감소 | 3.중지");
			System.out.println("--------------------");
			System.out.println("선택: ");

			keycode = System.in.read();

			if(keycode == 49) {
				speed++;
				System.out.println("현재 속도=" + speed);
			}
			else if(keycode == 50) {
				speed--;
				System.out.println("현재 속도=" + speed);
			}
			else if(keycode == 51) {
				run = false;
			}
			else {
				System.out.println(keycode);
			}
		}

		System.out.println("프로그램 종료");
	}
}
