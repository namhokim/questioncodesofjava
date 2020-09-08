package com.naver.cafe.thisisjava.tallure1969;

public class SwitchCharExample {
    public static void main(String[] args) {

        char grade = 'B';

        switch (grade) {
            case 'A': // A는 실행문이 없음. 그냥 넘어가짐.
            case 'a': // a는 실행문이 있으나 해당되지 않아 넘어감
                System.out.println("VIP 입니다.");
                break;
            case 'B': //실행코드가 없음. 그냥 넘어가짐
            case 'b':
                System.out.println("일반 회원입니다.");
                break;
            default:
                System.out.println("손님입니다.");
        }
    }
}
