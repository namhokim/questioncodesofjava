package com.example.springboot.sandbox.naver.party7458;

import java.util.stream.IntStream;

public class NthGreateNumberFinder {
    private static int N = 10;

    public static void main(String[] args) {
        int[] a = IntStream.range(1, 1 + 5).toArray();
        int[] b = IntStream.range(4, 4 + 5).toArray();
        int nTh = 3;
        System.out.println(findO_N(a, b, nTh));
    }

    /**
     * O(n) 알고리즘
     */
    static int findO_N(int[] a, int[] b, int nTh) {
        if (nTh < 1) {
            return -1;
        }

        int ai = a.length -1;
        int bi = b.length -1;
        int remainDepth = nTh;

        while (ai >= 0 && bi >= 0) {
            if (remainDepth == 1) {
                return Math.max(a[ai], b[bi]);
            }
            if (a[ai] > b[bi]) {
                --ai;
            } else if (a[ai] < b[bi]) {
                --bi;
            } else {
                --ai;
                --bi;
            }
            --remainDepth;
        }

//        if (nTh > a.length + b.length) {
//            return -1;
//        }
//
//        if (a[a.length-1] <= b[b.length-1]) {
//            return find2(a, b, nTh);
//        }
//        return find2(b, a, nTh);
        return -1;
    }

    /**
     * 비교
     * @param a 보다 작은 배열
     * @param b 최대값이 포함한 배열
     * @param nTh n번째 큰수의 n
     * @return n번째 큰수
     */
    static int find2(int[] a, int[] b, int nTh) {
        int nHtOfB = b.length - nTh;
        if (nHtOfB < 0) {
            int nHtOfA = a.length - (nTh - b.length);
            if (nHtOfA < 0) {
                return -1;
            }
            return a[nHtOfA];
        }
        int v = b[nHtOfB];

        return v;
    }
}
