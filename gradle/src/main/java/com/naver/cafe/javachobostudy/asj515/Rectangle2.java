package com.naver.cafe.javachobostudy.asj515;

import java.util.ArrayList;
import java.util.Collection;
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

    public static int computeArea(Collection<Rectangle> rooms) {  // static method로 변경
        return rooms.stream()
                .map(Rectangle::getArea)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
