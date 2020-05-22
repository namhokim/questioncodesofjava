package com.naver.cafe.javachobostudy.mong97;

import java.util.Objects;

public class Point {
    int x, y;

    public Point() {
        x = y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) {
            return true;
        }
        if (!(p instanceof Point)) {
            return false;
        }
        Point point = (Point) p;
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
