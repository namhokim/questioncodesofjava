package com.naver.cafe.javachobostudy.asj515;

import java.util.ArrayList;
import java.util.List;

public class Rectangle2 {
    public static void main(String[] args) {
        List<Rectangle> rooms = new ArrayList<>();
        rooms.add(Rectangle.of("kitchen", 20, 15));
        rooms.add(Rectangle.of("living room", 20, 20));
        rooms.add(Rectangle.of("den", 15, 10));
        rooms.add(Rectangle.of("bedroom 1", 18, 15));
        rooms.add(Rectangle.of("bedroom 2", 10, 8));

        System.out.println(computeArea(rooms));
    }

    public static int computeArea(Iterable<Rectangle> rooms) {  // static method로 변경
        int squarefoot = 0;
        for (Rectangle room : rooms) { // enhanced for loop으로 변경
            squarefoot += room.getArea(); // x = x + y 는 x += y 로 변경 가능
        }
        return squarefoot;
    }
}
