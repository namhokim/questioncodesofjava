package com.naver.cafe.thisisjava.tallure1969;

//import com.naver.InstrumentationAgent;

// VM options: -javaagent:$ProjectFileDir$/lib/InstrumentationAgent.jar
public class MultipleArrayInt {
    public static void main(String[] args) {
        int[][] multipleArray = new int[2][3];
        if (multipleArray instanceof Object) {
            System.out.println("Yes!");
        }
        printObjectSize(multipleArray);

        for (int[] score : multipleArray) {
            for (int item : score) {
                System.out.println(item);
            }
        }
    }

    public static void printObjectSize(Object object) {
//        System.out.println("Object type: " + object.getClass() +
//                ", size: " + InstrumentationAgent.getObjectSize(object) + " bytes");
    }
}
