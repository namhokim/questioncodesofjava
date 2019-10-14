package com.example.springboot.sandbox.naver.sang.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class School {

    public static void main(String[] args) {
        Students students = new Students();

        // 학생 5명 추가
        Student student1 = new Student(1111, "aaaa", 56);
        Student student2 = new Student(2222, "bbbb", 32);
        Student student3 = new Student(3333, "cccc", 86);
        Student student4 = new Student(4444, "dddd", 65);
        Student student5 = new Student(5555, "eeee", 13);

        // 배열에 저장
        students.append(student1);
        students.append(student2);
        students.append(student3);
        students.append(student4);
        students.append(student5);

        System.out.println("dddd학생의 정보");
        System.out.println(students.getByName("dddd"));
        System.out.println("-----------");
        System.out.println("학생 목록");
        System.out.print(students);
        System.out.println("-----------");
        System.out.println("성적순 정렬");
        students.sortByScore();
        System.out.print(students);
        System.out.println("-----------");
        System.out.println("가장 점수가 낮은 학생의 정보");

        Student stutemp = students.StudentAt(4);
        stutemp.changeScore(90);
        System.out.println(stutemp);
        System.out.println("-----------");

        System.out.println("학번순 정렬");
        students.sortById();
        System.out.print(students);

        System.out.println("-----------");
        System.out.println("평균점수: " + students.average());
    }
}

class Student {
    // 학번
    private int id;

    // 이름
    private String name;

    // 점수
    private int score;

    // 생성자
    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    // id를 return하는 메소드
    public int getId() {
        return id;
    }

    // name을 return하는 메소드
    public String getName() {
        return name;
    }

    // score를 return하는 메소드
    public int getScore() {
        return score;
    }

    // score를 바꿀 수 있는 메소드
    public void changeScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", 이름: " + this.name + ", 성적:" + this.score;
    }
}

class Students {
    // Student 리스배열
    private List<Student> students;

    // 생성자
    public Students() {
        students = new ArrayList<>();
    }

    // i번째 학생을 return
    public Student StudentAt(int i) {
        return students.get(i);
    }

    // 학생 추가
    public void append(Student s) {
        students.add(s);
    }

    // name과 일치하는 이름의 학생 return
    public Student getByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student s: students) {
            sb.append(s);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    // 학번순으로 정렬
    public void sortById() {
        students.sort(Comparator.comparingInt(Student::getId));
    }

    // 성적순으로 정렬
    public void sortByScore() {
        students.sort((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()));
    }

    // 전체 학생의 평균을 return
    public double average() {
        int sum = 0;
        for (Student student: students) {
            sum += student.getScore();
        }
        return (double) sum / students.size();
    }
}