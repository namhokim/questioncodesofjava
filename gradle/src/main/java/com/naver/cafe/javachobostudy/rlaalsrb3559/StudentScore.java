package com.naver.cafe.javachobostudy.rlaalsrb3559;
import java.util.Scanner;

/*사용자로부터 5명의 성적을 입력 받아 총점과 평균을 구하는 클래스 StudentScore 를 작성하시오.
메소드 getScore() 는 인원수 만큼 학생의 성적을 입력 받아 score 배열에 저장
메소드 totalScore 는 배열 score[] 변수에 있는 값을 이용하여 총점을 계산하고 totalScore 변수에 저장
메소드 calcAverage() 는 총점과 인원수를 이용하여 평균을 계산하고 averageScore 변수에 저장
메소드 printResult() 는 인원수, 총점 과 평균을 출력
테스트를 위해 클래스 Test 를 생성하고 클래스 StudentScore 를 호출하여 각 메소드를 수행한다.
*/
public class StudentScore {
    final int STUDENT=5;
    int total=0;
    Scanner scan= new Scanner(System.in);
    int scores[]=new int[STUDENT];

    public void getScore() {
        for(int i = 0;i<STUDENT;i++) {
            System.out.println("성적을 입력하세요: ");
            scores[i]=scan.nextInt();
        }
    }

    public void totalScore() {
        for(int i=0;i<STUDENT;i++) {
            total+=scores[i];
            int totalScore = total;
        }
    }

    public void calcAverage() {
        int averageScore=total/STUDENT;
    }

    public void printResult() {
        System.out.println("총점은: "+total);
        System.out.println("평균은: ");
    }
}
