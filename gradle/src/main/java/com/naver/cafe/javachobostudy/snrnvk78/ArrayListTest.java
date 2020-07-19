package com.naver.cafe.javachobostudy.snrnvk78;

import java.util.*;

public class ArrayListTest {
    public List<String> getGroceryList() {
        List<String> data = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            data.add(Integer.toString(i));
        }
        return data;
    }

    public static void main(String[] args) {
        processArrayList();
    }

    public static void processArrayList() {
        ArrayListTest groceryList = new ArrayListTest();

        ArrayList<String> newArray = new ArrayList<String>();  // <- 1번
        newArray.addAll(groceryList.getGroceryList()); //  <- 2번

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList()); // 3번

//        String[] myArray = new String[groceryList().size()]; // 4번
        String[] myArray = new String[100]; // 4번
        final List<String> groceryList1 = groceryList.getGroceryList();
        groceryList1.toArray(myArray); // 5번

        Arrays.stream(myArray).forEach(System.out::println);
    }

    private static Collection<String> groceryList() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(Integer.toString(i));
        }
        return data;
    }
}
