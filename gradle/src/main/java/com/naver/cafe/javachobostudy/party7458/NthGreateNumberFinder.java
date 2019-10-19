package com.naver.cafe.javachobostudy.party7458;

public class NthGreateNumberFinder {
    /**
     * O(n) 알고리즘
     */
    static int findO_N(int[] a, int[] b) {
        assert (a.length == b.length);
        int nTh = a.length;
        int ai = a.length - 1;
        int bi = b.length - 1;
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
        return -1;
    }

    /**
     * log(N)
     */
    static int findO_LogN(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2;
    }

    static int getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) {
            return B[bStart + k - 1];
        }
        if (bStart > B.length - 1) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return Math.max(A[aStart], B[bStart]);
        }

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) aMid = A[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < B.length) bMid = B[bStart + k / 2 - 1];

        if (aMid < bMid) {
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2); // Check: aRight + bLeft
        } else {
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2); // Check: bRight + aLeft
        }
    }
}
