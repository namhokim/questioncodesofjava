package com.naver.cafe.javachobostudy.sang.refactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private int score;

    private Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public static Student of(int id, String name, int score) {
        return new Student(id, name, score);
    }

    @Override
    public String toString() {
        return "(id:" + id +
                ", 이름:'" + name +
                ", 점수:" + score +
                ")";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
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
