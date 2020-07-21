package com.naver.cafe.javachobostudy.asj515;

public class Rectangle {
    private int length;
    private int width;

    public int getLength() {
        return length;
    }

    public void setLength(int len) {
        length = len;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int wid) {
        width = wid;
    }

    public Rectangle(int len, int wid) {
        length = len;
        width = wid;
    }
    Rectangle classroom = new Rectangle(15,20);
    public int getArea() {
        return length * width;
    }
}
