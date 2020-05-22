package com.naver.blog.mommoo;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayEnhancedFor {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ArrayList<Integer> arrayList = new ArrayList<>(array.length);
        for (int i : array) {
            System.out.println(i);
            arrayList.add(i);
        }

        for (int i : arrayList) {   // iterator
            System.out.println(i);
        }
        // 아래의 형태의 바이트코드로 컴파일된다.
        final Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            final Integer next = iterator.next();
            int i = next.intValue();
            System.out.println(i);
        }
    }
}
