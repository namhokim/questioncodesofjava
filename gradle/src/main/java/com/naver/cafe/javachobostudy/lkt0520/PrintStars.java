package com.naver.cafe.javachobostudy.lkt0520;

public class PrintStars {
    public static CharSequence display(int count, char character) {
        StringBuilder builder = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
        return builder;
    }

    public static String display2(int count, char character) {
        String output = "";
        for (int i = 0; i < count; i++) {
            output += character;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(display(7, '*'));
        System.out.println(display2(7, '*'));
    }
}
