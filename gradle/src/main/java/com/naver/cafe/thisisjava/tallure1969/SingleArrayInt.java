package com.naver.cafe.thisisjava.tallure1969;

// VM options: -javaagent:$ProjectFileDir$/lib/InstrumentationAgent.jar
public class SingleArrayInt {
    public static void main(String[] args) {
        short[] array = new short[Short.MAX_VALUE];
        if (array instanceof Object) {
            System.out.println("Yes!");
        }
        MultipleArrayInt.printObjectSize(array);
    }
}
