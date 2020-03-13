package com.naver.cafe.javachobostudy.pse0357;

public class Student extends Person{
    String studentId;   // 학번

    // this 키워드를 사용하여 name, age, studentId를 초기화하는 생성자

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    String info() {
        return super.info() + ", 학번 : " + studentId;
    }
}
