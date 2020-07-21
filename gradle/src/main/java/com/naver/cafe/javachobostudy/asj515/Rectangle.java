package com.naver.cafe.javachobostudy.asj515;

public class Rectangle {
    private final int length; // setter (setLength 메서드)를 지우면 immutable 가능하므로 final 가능
    private final int width;  // setter (setWidth 메서드)를 지우면 immutable 가능하므로 final 가능

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
    public Rectangle(int length, int width) {    // 축약된 len, wid 보다는 전체 단어가 이해하기 쉬움
        this.length = length;   // 멤버변수와 이름이 겹치므로 this.length 로 구별해줌
        this.width = width;     // 멤버변수와 이름이 겹치므로 this.width 로 구별해줌
    }

    public int getArea() {
        return length * width;
    }
}
