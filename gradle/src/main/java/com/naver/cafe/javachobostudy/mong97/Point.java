package com.naver.cafe.javachobostudy.mong97;

public class Point {
    int x, y;

    public Point () {
        x = y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    public boolean equals(Point p) {
        return ( p.x == x && p.y == y);
    }
}
