package com.naver.cafe.javachobostudy.wnstn798;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Action {
    public void actionPerformed(ActionEvent e) {
        File file = new File("/Users/namo/Desktop/Person.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String A = sc.nextLine();
                System.out.println(A);
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Action action = new Action();
        action.actionPerformed(null);
    }
}
