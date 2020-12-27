package com.naver.cafe.thisisjava.cys1226eg;

public class DetectOverflow {

    public static int safeAdd(int left, int right)
    {
        if ((right > 0)) {
//            if (left > (Integer.MAX_VALUE - right))  // <-- 이 부분을
            int result = left + right;
            if (left + right > Integer.MAX_VALUE)
            {
                throw new ArithmeticException("오버플로우 발생");
            }
        }
        else
        {
//            if (left < (Integer.MIN_VALUE - right)) // <--  이 부분을
            if(left+right < Integer.MIN_VALUE)
            {
                throw new ArithmeticException("오버플로우 발생");
            }
        }
        return left + right;
    }

    public static void main(String[] args) {
        final int i = DetectOverflow.safeAdd(Integer.MAX_VALUE - 1, 1);
        System.out.println(i);
    }

}
