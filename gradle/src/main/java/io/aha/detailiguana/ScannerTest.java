package io.aha.detailiguana;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("문장 입력 : ");
            String line = scanner.nextLine();

            if ("그만".equals(line)) {
                System.out.println("종료합니다.");
                break;
            }

            System.out.println(wrap(line));
        }
    }

    public static String wrap(String line) {
        String[] words = line.split("\\s");
        int wordSize = words.length;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < wordSize; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            if (i >= wordSize - 2) {
                sb.append("[");
            }
            sb.append(words[i]);
            if (i >= wordSize - 2) {
                sb.append("]");
            }
        }
        return sb.toString();
    }

}
