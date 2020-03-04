package com.naver.cafe.javachobostudy.mtic3370;

public class PersonConstructor {
    String name;
    int age;
    String addr;

    public PersonConstructor() {
        name = "이름없음";
        age = 1;
        addr = "미상";
        System.out.println("나는 기본생성자 입니다");
    }

    public PersonConstructor(String name) {
        this.name = name;
        age = 1;
        addr = "출처불명";
    }

//public Person...이 앞으로 당겨지지 않아서 이대로 쓰는것입니다.

    public PersonConstructor(String name, int age) {
        this(name, age, "미상");
        System.out.println("나는 인자생성자[2] 입니다");
    }


//public Person...이 앞으로 당겨지지 않아서 이대로 쓰는것입니다.

    public PersonConstructor(String _name, int age, String addr) {
        name = _name;
        this.age = age;
        this.addr = addr;
        System.out.println("나는 인자생성자[3] 입니다");

    }


//void initialize 이 앞으로 당겨지지 않아서 이대로 쓰는것입니다.

    void initialize(String name, int age, String addr) {

        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    void showPersonInfo() {

        System.out.printf("%s 님의 정보\n", this.name);
        System.out.printf("나이:%d\n", age);
        System.out.printf("주소:%s\n", addr);
    }
}
