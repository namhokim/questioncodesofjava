package com.naver.cafe.javachobostudy.rlawodns11111;

public class ArrayCompare {
    public static void main(String[] args) {
        int[] Arr1 = {1, 2, 3};
        int[] Arr2 = {1, 2, 3};

        for (int i = 0; i < Arr1.length; i++) {
            for (int j = 0; j < Arr2.length; j++) {
                if (Arr1[i] == Arr2[j]) {
                    System.out.println("같아요");
                } else {
                    System.out.println("달라요");
                }
            }
        }
    }

}
