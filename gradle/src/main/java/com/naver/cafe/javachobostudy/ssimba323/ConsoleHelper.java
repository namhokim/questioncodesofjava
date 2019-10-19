package com.naver.cafe.javachobostudy.ssimba323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ConsoleHelper {

    private BufferedReader in;
    private PrintStream out;

    private ConsoleHelper(BufferedReader reader, PrintStream out) {
        this.in = reader;
        this.out = out;
    }

    private static ConsoleHelper build() {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        return new ConsoleHelper(reader, System.out);
    }

    public static void main(String[] args) throws IOException {
        String[] menu = {"Coffee", "Tea", "Water"};
        ConsoleHelper helper = ConsoleHelper.build();
        helper.out.println("Menu");
        helper.out.println("1. Coffee");
        helper.out.println("2. Tea");
        helper.out.println("3. Water");
        helper.out.print("? ");

        String order = helper.in.readLine();
        final int menuNumber = Integer.parseInt(order);
        helper.out.printf("You choose %s", menu[menuNumber - 1]);

    }
}
