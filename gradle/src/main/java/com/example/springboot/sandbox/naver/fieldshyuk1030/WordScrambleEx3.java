package com.example.springboot.sandbox.naver.fieldshyuk1030;

import java.util.Scanner;

public class WordScrambleEx3 {
    public static void main(String[] args) {
        String[] strArr = {"CHANGE", "LOVE", "HOPE", "VIEW"};
        A:
        while (true) {
            String s1 = getAnswer(strArr);
            String s2 = getScrambledWord(s1);

            System.out.println("Question :" + s2);
            while (true) {
                System.out.print("Your answer is :");
                Scanner sc = new Scanner(System.in);
                String s3 = sc.nextLine().trim();
                if (s3.equalsIgnoreCase(s1)) {
                    System.out.println("정답입니다.");
                    break;
                }
                if (s3.equalsIgnoreCase("q"))
                    break A;
                System.out.println(s3 + "은/는 정답이 아닙니다. 다시 시도해보세요.");
                System.out.println("Question :" + s2);
            }
        }
    }

    public static String getAnswer(String[] strArr) {
        int idx = (int) (Math.random() * strArr.length);
        return strArr[idx];
    }

    public static String getScrambledWord(String str) {
        char[] chArr = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            int idx = (int) (Math.random() * str.length());

            char tmp = chArr[i];
            chArr[i] = chArr[idx];
            chArr[idx] = tmp;
        }
        return new String(chArr);
    }

}
