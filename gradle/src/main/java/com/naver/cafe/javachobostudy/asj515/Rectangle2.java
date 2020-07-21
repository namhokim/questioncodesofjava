package com.naver.cafe.javachobostudy.asj515;

import java.util.Arrays;
import java.util.Iterator;

public class Rectangle2 {
    public static void main(String[] args) {
        Rectangle kitchen = Rectangle.of("kitchen", 20, 15);
        Rectangle livingRoom = Rectangle.of("living room", 20, 20); // 거실은 living room 으로 복합 단어이므로 R로 단어를 구분
        Rectangle den = Rectangle.of("den", 15, 10);
        Rectangle bedroom = Rectangle.of("bedroom 1", 18, 15);
        Rectangle bedroom2 = Rectangle.of("bedroom 2", 10, 8);

        Rectangle[] rooms = new Rectangle[5];
        rooms[0] = kitchen;
        rooms[1] = livingRoom;  // 배열 첨자 0 -> 1
        rooms[2] = den;         // 배열 첨자 0 -> 2
        rooms[3] = bedroom;     // 배열 첨자 0 -> 3
        rooms[4] = bedroom2;    // 배열 첨자 0 -> 4
        System.out.println(computeArea(Arrays.asList(rooms)));
    }

    public static int computeArea(Iterable<Rectangle> rooms) {  // static method로 변경
        int squarefoot = 0;
        for (Rectangle room : rooms) { // enhanced for loop으로 변경
            squarefoot += room.getArea(); // x = x + y 는 x += y 로 변경 가능
        }
        return squarefoot;
    }
}
