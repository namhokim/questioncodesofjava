package com.naver.cafe.thisisjava.tallure1969;

// VM options: -javaagent:$ProjectFileDir$/lib/InstrumentationAgent.jar
public class SingleArrayObject {

    public static void main(String[] args) {
        Object[] object = new Object[6];
        SingleArrayInt.printObjectSize(object);

        for (int i = 0; i< 100; i++) {
            createObjectArray(i);
        }
    }

    private static void createObjectArray(int size) {
        System.out.printf("\nSize: %d\n", size);
        SingleArrayObject[] arrayObjects = new SingleArrayObject[size];
        if (arrayObjects instanceof Object) {
            System.out.println("Yes!");
        }
        SingleArrayInt.printObjectSize(arrayObjects);
//        initializeArray(arrayObjects);
//        MultipleArrayInt.printObjectSize(arrayObjects);
    }

    private static void initializeArray(SingleArrayObject[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new SingleArrayObject();
        }
    }
}
