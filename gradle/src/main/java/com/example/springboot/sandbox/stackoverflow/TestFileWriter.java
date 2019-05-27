package com.example.springboot.sandbox.stackoverflow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestFileWriter {
    public void test() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter your name");
            String name = Keyboard.readInput();
            System.out.println("Name:" + name);
            System.out.println("Enter your age");
            int age = Integer.parseInt(Keyboard.readInput());
            System.out.println("Age:" + age);
        }
        System.out.println("enter 1 to save to file");
        int num = Integer.parseInt(Keyboard.readInput());
        if (num == 1) {
            System.out.println("Enter the file name to write to:\n");
            String filename = Keyboard.readInput();
            File myfile = new File(filename);

            try {
                PrintStream out = new PrintStream(new FileOutputStream(myfile));
                System.setOut(out);
            } catch (IOException e) {
                System.out.println("Error:" + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        TestFileWriter writer = new TestFileWriter();
        writer.test();
    }
}
