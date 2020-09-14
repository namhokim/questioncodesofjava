package com.naver.cafe.thisisjava.tallure1969;

import com.naver.InstrumentationAgent;

// VM options: -javaagent:$ProjectFileDir$/lib/InstrumentationAgent.jar
public class SingleArrayInt {
    public static void main(String[] args) {
        short[] array = new short[Short.MAX_VALUE];
        if (array instanceof Object) {
            System.out.println("Yes!");
        }
        printObjectSize(array);
    }

    public static void printObjectSize(Object object) {
        System.out.println("Object type: " + object.getClass() +
                ", size: " + InstrumentationAgent.getObjectSize(object) + " bytes");
    }
}
