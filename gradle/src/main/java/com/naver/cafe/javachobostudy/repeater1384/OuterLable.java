package com.naver.cafe.javachobostudy.repeater1384;

public class OuterLable {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3, 4};

        outer:
        {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    break outer;
                }
            }
            // break 문 없이 다 돌 았을 때
            System.out.println("non exist");
            return;
        }

        System.out.println("exist");
    }
}


