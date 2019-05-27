package com.example.springboot.sandbox.naver.sang.refactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentList {
    public static void main(String[] args) {
        List<Student> students =  new ArrayList<>();
        students.add(Student.of(1, "CHOI", 98));
        students.add(Student.of(2, "LEE", 94));
        students.add(Student.of(3, "LIM", 93));
        students.add(Student.of(4, "KIM", 99));
        students.add(Student.of(5, "JEONG", 91));

        // List의 toString 으로 전체 학생을 순서대로 호출
        System.out.println(students);

        // 세 번째 원소의 학생을 출력
        int select = 2;
        Student f = students.get(2);
        System.out.println("<list[" + select + "] 의 id, 이름, 점수>");
        System.out.println("id: " + f.getId() + "  이름: " + f.getName() + "  점수: " + f.getScore());

        Collections.reverse(students);
        System.out.println("추가한 학생 순서를 뒤집어서 출력\n" + students);

        students.sort(Comparator.comparingInt(Student::getId));
        System.out.println("id 순으로 출력:\n" + students);

        students.sort((s1, s2) -> s2.getScore() - s1.getScore());
        System.out.println("점수가 높은 순으로 출력\n" + students);

        students.stream()
                .mapToInt(Student::getScore)
                .average()
                .ifPresent(avg -> System.out.println("평균 점수 출력: " + avg));
    }
}
