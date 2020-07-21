package com.naver.cafe.javachobostudy.asj515;

public class Rectangle2 {
    public static void main(String[] args) {
        Rectangle kitchen = new Rectangle(20,15);
        Rectangle livingroom = new Rectangle(20,20);
        Rectangle den = new Rectangle(15,10);
        Rectangle bedroom = new Rectangle(18,15);
        Rectangle bedroom2 = new Rectangle(10,8);

        Rectangle[] rooms = new Rectangle[5];
        rooms[0] = kitchen;
        rooms[0] = livingroom;
        rooms[0] = den;
        rooms[0] = bedroom;
        rooms[0] = bedroom2;
    }

    public int computeArea(Rectangle[] rooms) {
        int squarefoot = 0;
        for (int r=0;r<rooms.length; r++) {
            squarefoot = squarefoot + rooms[r].getArea();
        }
        return squarefoot;
    }
}
