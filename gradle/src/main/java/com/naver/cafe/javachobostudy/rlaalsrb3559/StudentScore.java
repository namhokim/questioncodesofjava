package com.naver.cafe.javachobostudy.rlaalsrb3559;

import java.util.Scanner;

/**
 * 사용자로부터 5명의 성적을 입력 받아 총점과 평균을 구하는 클래스 StudentScore 를 작성하시오.
 * 메소드 getScore() 는 인원수 만큼 학생의 성적을 입력 받아 score 배열에 저장
 * 메소드 totalScore 는 배열 score[] 변수에 있는 값을 이용하여 총점을 계산하고 totalScore 변수에 저장
 * 메소드 calcAverage() 는 총점과 인원수를 이용하여 평균을 계산하고 averageScore 변수에 저장
 * 메소드 printResult() 는 인원수, 총점 과 평균을 출력
 * 테스트를 위해 클래스 Test 를 생성하고 클래스 StudentScore 를 호출하여 각 메소드를 수행한다.
 */
class StudentScore {
    private static final int STUDENT = 5;
    private static final int NOT_INITIALIZED = -1;

    private int[] scores = new int[STUDENT];
    private int totalScore = NOT_INITIALIZED;
    private int averageScore = NOT_INITIALIZED;

    void getScore() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < STUDENT; i++) {
            System.out.println("성적을 입력하세요: ");
            scores[i] = scan.nextInt();
        }
    }

    void totalScore() {
        int total = 0;
        for (int i = 0; i < STUDENT; i++) {
            total += scores[i];
        }
        this.totalScore = total;
    }

    void calcAverage() {
        if (this.totalScore == NOT_INITIALIZED) {
            totalScore();
        }
        this.averageScore = this.totalScore / STUDENT;
    }

    void printResult() {
        if (this.averageScore == NOT_INITIALIZED) {
            calcAverage();
        }
        System.out.println("총점은: " + this.totalScore);
        System.out.println("평균은: " + this.averageScore);
    }
}

class Test {
    public static void main(String[] args) {
        StudentScore studentScore = new StudentScore();
        studentScore.getScore();
        studentScore.totalScore();
        studentScore.calcAverage();
        studentScore.printResult();
    }
}
