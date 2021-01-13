package com.naver.cafe.thisisjava.thevu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamMapIntegerAverage {
    public static void main(String[] args) {
        List<String> list2 = new ArrayList<>();
        list2.add("1,2");
        list2.add("3,4");

        double output = list2.stream().flatMapToInt(data->{
            String[] strArr = data.split(",");
            int[] intArr = new int[strArr.length];

            for(int i=0; i<strArr.length; i++){
                intArr[i] = Integer.parseInt(strArr[i].trim());
            }

            return Arrays.stream(intArr);
        })
        .average()
        .getAsDouble();

        System.out.println(output);
    }
}
