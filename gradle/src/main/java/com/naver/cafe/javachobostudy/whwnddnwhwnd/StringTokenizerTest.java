package com.naver.cafe.javachobostudy.whwnddnwhwnd;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("입력");
        String num = sc.nextLine();

        StringTokenizer str = new StringTokenizer(num, ",");

        int[] arr = new int[1000];
        System.out.println("출력");
        int countOfTokens = str.countTokens();
        for (int i = 0; i < countOfTokens; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
            System.out.println(arr[i]);
        }
    }
}
