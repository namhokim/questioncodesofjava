package com.naver.cafe.thisisjava.tallure1969;

import org.openjdk.jol.info.ClassLayout;

// VM options: -javaagent:$ProjectFileDir$/lib/InstrumentationAgent.jar
public class MultipleArrayInt {
    public static void main(String[] args) {

        int[][] multipleArray = new int[2][3];
        System.out.println(ClassLayout.parseInstance(multipleArray).toPrintable());
        System.out.println(ClassLayout.parseInstance(multipleArray[0]).toPrintable());
    }

}
