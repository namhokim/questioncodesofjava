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

    private Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public static Rectangle of(int length, int width) {
        return new Rectangle(length, width);
    }

    public int getArea() {
        return length * width;
    }
}
