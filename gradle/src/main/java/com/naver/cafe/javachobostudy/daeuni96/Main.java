package com.naver.cafe.javachobostudy.daeuni96;

import java.util.ArrayList;

public class Main extends Manager {
    ArrayList<Restaurant> rList;
    ArrayList<User> uList;

    void print() {
        for (Restaurant r : rList) {
            r.print();
        }
        for (User r : uList) {
            r.print();
        }
    }
}
