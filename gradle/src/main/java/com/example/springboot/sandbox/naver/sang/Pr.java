package com.example.springboot.sandbox.naver.sang;

public class Pr {
    public static void main(String[] args) {
        int size = 5;
        double total;
        StudentList list = new StudentList(size);
        Student a, b, c, d, e;
        Student f;

        a = new Student();
        a.setId(1);
        a.setName("CHOI");
        a.setScore(98);
        list.append(a);

        b = new Student();
        b.setId(2);
        b.setName("LEE");
        b.setScore(94);
        list.append(b);

        c = new Student();
        c.setId(3);
        c.setName("LIM");
        c.setScore(93);
        list.append(c);

        d = new Student();
        d.setId(4);
        d.setName("KIM");
        d.setScore(99);
        list.append(d);

        e = new Student();
        e.setId(5);
        e.setName("JEONG");
        e.setScore(91);
        list.append(e);

        System.out.println(list.toString());//toString 으로 전체 학생을 순서대로 호출

        int select = 2;
        f = list.studentAt(select); // 배열에서 [2]를 출력 {0~4} 총 5개
        System.out.println("<list[" + select + "] 의 id, 이름, 점수>");
        System.out.println("id: " + f.getId() + "  이름: " + f.getName() + "  점수: " + f.getScore());

        list.reverse(); // append에  추가한 학생 순서를 뒤집어서 출력
        list.sortById();  // id 순으로 출력
        list.sortByScore(); // 점수가 높은 순으로 출력
        total = list.average(); // 점수 평균을 저장
        System.out.println("평균 점수: " + total);  // 평균 점수 출력


    }
}

class Student {
    private int id;
    private String name;
    private int score;

    //set은 값을 입력하는 함수
    public void setId(int id) {
        this.id = id; //현재 객체의 시작번지값을 가리킴
    }

    //get은 변수에 저장된 값을 읽어오는 함수
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    //setScore 점수를 changeScore 점수로 바꿈
    public void changeScore(int Score) {
        score = Score;
    }

    public String toString() {
        return ("id:" + id + " ,name:" + name + " ,score:" + score);
    }
}

class StudentList {
    private Student[] Students;
    private int number = 0;

    public StudentList(int size) {
        Students = new Student[size];
    }

    public void append(Student student) {
        Students[number++] = student;
    }

    public Student studentAt(int index) {
        return Students[index];
    }

    public void sortById() {
        for (int i = 0; i < Students.length; i++) {
            for (int j = 0; j < Students.length; j++) {
                if (Students[i].getId() > Students[j].getId()) {
                    Student temp = Students[i];
                    Students[i] = Students[j];
                    Students[j] = temp;
                }
            }
        }
        System.out.println("<id 오름 차순>");
        for (int i = 0; i < Students.length; i++)
            System.out.println("id: " + Students[i].getId() + "  이름: " + Students[i].getName()
                    + "  점수: " + Students[i].getScore());
    }

    public void sortByScore() {
        for (int i = 0; i < Students.length; i++) {
            for (int j = 0; j < Students.length; j++) {
                if (Students[i].getScore() < Students[j].getScore()) {
                    Student temp = Students[i];
                    Students[i] = Students[j];
                    Students[j] = temp;
                }
            }
        }
        System.out.println("<점수 내림차순>");
        for (int i = 0; i < Students.length; i++)
            System.out.println("id: " + Students[i].getId() + "  이름: " + Students[i].getName()
                    + "  점수: " + Students[i].getScore());
    }

    public void reverse() {
        for (int i = 0; i < Students.length / 2; i++) {
            Student temp = Students[i];
            Students[i] = Students[Students.length - 1 - i];
            Students[Students.length - 1 - i] = temp;
        }
        System.out.println("<순서를 역순으로 변경>");
        for (int i = 0; i < Students.length; i++)
            System.out.println("id: " + Students[i].getId() + "  이름: " + Students[i].getName()
                    + "  점수: " + Students[i].getScore());
    }

    public double average() {
        double average1 = 0;
        for (int i = 0; i < number; i++)
            average1 += Students[i].getScore();
        return average1 / number;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            stringBuilder.append("id: ").append(Students[i].getId())
                    .append(":이름:").append(Students[i].getName())
                    .append("점수: ").append(Students[i].getScore())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
