package com.naver.cafe.javachobostudy.whwnddnwhwnd;

import java.util.Arrays;
import java.util.Scanner;

public class StringTokenizerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("입력");
        String num = sc.nextLine();

        int[] arr = Arrays.stream(num.split(",")).mapToInt(Integer::parseInt).toArray();
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
