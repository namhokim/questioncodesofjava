package com.naver.blog.justkukaro;

public class Test {
    public static void main(String[] args) {
        Point<Integer> p = new Point<>(10, 20);
        //Point p = new Point(10, 20);
        p.print();
    }
}

class Point<E> {
    private E x;
    private E y;

    Point(E x, E y) {
        this.x = x;
        this.y = y;
    }

    void swap() {
        E tmp = x;
        x = y;
        y = tmp;
    }

    void print() {
        System.out.println(x);
        System.out.println(y);
    }
}

class PointAssume {
    private Integer x;
    private Integer y;

    PointAssume(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    void swap() {
        Integer tmp = x;
        x = y;
        y = tmp;
    }

    void print() {
        System.out.println(x);
        System.out.println(y);
    }
}
