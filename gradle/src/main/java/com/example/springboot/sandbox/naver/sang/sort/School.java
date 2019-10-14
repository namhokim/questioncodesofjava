package com.example.springboot.sandbox.naver.sang.sort;

public class School {

    public static void main(String[] args) {
        Students stus = new Students();

        // 학생 5명 추가
        Stu stu1 = new Stu(1111, "aaaa", 56);
        Stu stu2 = new Stu(2222, "bbbb", 32);
        Stu stu3 = new Stu(3333, "cccc", 86);
        Stu stu4 = new Stu(4444, "dddd", 65);
        Stu stu5 = new Stu(5555, "eeee", 13);

        Stu stutemp;

        // 배열에 저장
        stus.append(stu1);
        stus.append(stu2);
        stus.append(stu3);
        stus.append(stu4);
        stus.append(stu5);
        System.out.println("dddd학생의 정보");

        stutemp = (Stu) stus.getByName("dddd");
        stutemp.println();
        System.out.println("-----------");
        System.out.println("학생 목록");
        stus.print();
        System.out.println("-----------");
        System.out.println("성적순 정렬");
        stus.sortByScore();
        stus.print();
        System.out.println("-----------");
        System.out.println("가장 점수가 낮은 학생의 정보");

        stutemp = stus.StudentAt(4);
        stutemp.changeScore(90);
        stutemp.println();
        System.out.println("-----------");

        System.out.println("학번순 정렬");
        stus.sortById();
        stus.print();

        System.out.println("-----------");
        System.out.println("평균점수: " + stus.average());
    }
}

class Stu {
    // 학번
    private int id;

    // 이름
    private String name;

    // 점수
    private int score;

    // 생성자
    public Stu(int id, String name, int score) {
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

    // id, name, score를 출력하는 메소드
    public void println() {
        System.out.println("id: " + this.id + ", 이름: " + this.name + ", 성적:" + this.score);
    }
}

class Students {
    // Stu 배열
    private Stu[] stu;

    // 현재 배열에 있는 Stu 객체 수
    private int number = 0;

    // 생성자
    public Students() {
        stu = new Stu[100];
    }

    // i번째 학생을 return
    public Stu StudentAt(int i) {
        return stu[i];
    }

    // 학생 추가
    public void append(Stu s) {
        stu[number++] = s;
    }

    // name과 일치하는 이름의 학생 return
    public Stu getByName(String name) {
        for (int i = 0; i < number; i++) {
            if (stu[i].getName().equals(name))
                return stu[i];
        }
        return null;
    }

    // 배열 출력
    public void print() {
        for (int i = 0; i < number; i++) {
            System.out.println("id:" + stu[i].getId() + ", 이름: " + stu[i].getName() + ",성적: " + stu[i].getScore());
        }
    }

    // sort를 위한 메소드
    private void swap(int i, int j) {
        Stu temp;
        temp = stu[i];
        stu[i] = stu[j];
        stu[j] = temp;
    }

    // 학번순으로 정렬
    public void sortById() {
        int i, j, min;
        for (i = 0; i < number - 1; i++) {
            min = i;
            for (j = i + 1; j < number; j++) {
                if (stu[j].getId() < stu[min].getId()) {
                    min = j;
                }
            }
            if (i != min) {
                swap(i, min);
            }
        }
    }

    // 성적순으로 정렬
    public void sortByScore() {
        int i, j, max;
        for (i = 0; i < number - 1; i++) {
            max = i;
            for (j = i + 1; j < number; j++) {
                if (stu[max].getScore() < stu[j].getScore())
                    max = j;
            }
            if (i != max) {
                swap(i, max);
            }
        }
    }

    // 전체 학생의 평균을 return
    public double average() {
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum += stu[i].getScore();
        }
        return (double) sum / number;
    }
}