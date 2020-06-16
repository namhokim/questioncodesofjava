package com.naver.blog.justkukaro;

public class ChooseThreeBalls {
    public static void main(String[] args) {
        int target = 30;
        int[] balls = new int[]{1, 3, 5, 7, 9, 11, 13, 15};

        outer:
        for (int i = 0; i < balls.length; i++) {
            for (int j = 0; j < balls.length; j++) {
                for (int k = 0; k < balls.length; k++) {
                    int sum = balls[i] + balls[j] + balls[k];
                    if (sum == target) {
                        System.out.printf("%d %d %d", i, j, k);
                        break outer;
                    }
                }
            }
        }
    }
}
