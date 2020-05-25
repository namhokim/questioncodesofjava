package com.naver.cafe.javachobostudy.qkrdlfrnjs95;

public class ListEx {
    MyList<String> list1 = new MyList<String>();
    String strArr[] = {"java","Database","Network","Python"};
    list1.set(strArr); //이부분 오류.
    list1.printList();
}

class MyList<T>{
    T val;

    MyList(){
    }

    void set(T a) {
        val = a;
    }

    void printList(){
        System.out.println(val);
        System.out.println("--------------------------");
    }
}
