package io.aha.detailiguana;

import java.util.Scanner;

public class ExampleScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = null;

        while ((line = scanner.nextLine()) != null) {
            String newStr = wrap(line);
            System.out.println(line + "==>" + newStr);
        }
    }

    public static String wrap(String line) {
        line = line.trim();
        String spStr[] = line.split(" ");
        String newStr = "";

        for (int i = 0; i < spStr.length; i++) {
            if (i > 0) {
                newStr += " ";
            }

            if (i > spStr.length - 3) {
                newStr += "[" + spStr[i] + "]";
            } else {
                newStr += spStr[i];
            }
        }
        return newStr;
    }

}
