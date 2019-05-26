package naver.kirianir;

import java.util.Arrays;

public class Practive {
    public static void main(String[] args) {
        Student[] sArr = {
                new Student(100, "abc"),
                new Student(300, "aaa"),
                new Student(400, "ccc"),
                new Student(200, "bbb"),
        };

        System.out.println("Before: " + Arrays.toString(sArr));
        Arrays.sort(sArr);
        System.out.println("Later: " + Arrays.toString(sArr));
    }
}

class Student implements Comparable<Student> {
    private int score;
    private String name;

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student another) {
        System.out.println("this: " + this.toString() + " vs another: " + another.toString());
        return this.score - another.score;
    }
}