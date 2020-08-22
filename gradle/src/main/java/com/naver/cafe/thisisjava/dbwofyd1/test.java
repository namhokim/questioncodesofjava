package com.naver.cafe.thisisjava.dbwofyd1;

import lombok.SneakyThrows;

import java.io.IOException;

public class test {
	public static void main(String[] args) throws IOException {
		//값을 외부에서 받기 때문에 오류가 발생할 가능성이 높음
		//그렇기에 throws Exception(또는 IOException)을 입력하여 예외처리
		boolean run = true;
		int speed = 0;
		int keycode = 0;

		while(run) {
			if(keycode != 13 && keycode != 10) {
				//CR(13)->커서를 맨 앞으로 이동, LF(10)->다음줄로 이동
				//CR과 LF을 모두 실행하여야 Enter와 같은 효과
				System.out.println("--------------------");
				System.out.println("1.증속 | 2.감소 | 3.중지");
				System.out.println("--------------------");
				System.out.println("선택: ");
			}

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
		}

		System.out.println("프로그램 종료");
	}
}
