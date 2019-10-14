package com.example.springboot.sandbox.naver.lkt0520;

public class A000 {
    public static void main(String[] args) {
        int sum = 0;
        boolean isPositive = true;
        for (int i = 1; ; i++) {
            int currentValue = getValueBy(i, isPositive);
            sum = sum + currentValue;
            // System.out.println(i + ": " +sum);
            if (sum == 100) {
                System.out.println(currentValue + "/" + sum);
                break;
            }
            isPositive = !isPositive;
        }
    }

    /**
     * 양/음 플래그에 의해 값을 반환한다.
     * @param value 값
     * @param isPositive 양수 여부
     * @return isPositive 가 반영된 값
     */
    private static int getValueBy(int value, boolean isPositive) {
        if (isPositive) {
            return value;
        }
        return -value;
    }
}
