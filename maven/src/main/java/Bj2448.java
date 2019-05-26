import java.util.*;

public class Bj2448 {
    public static void main(String[] args) {
        System.out.println("Input Number: N은 항상 3×2^k 수이다. (3, 6, 12, 24, 48, ...) (k ≤ 10)");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        validateInput(n);
        printStars(n);
    }

    private static void printStars(int n) {
        validateInput(n);
        for (int i=0; i<=n; i++) {
            printLine(i);
        }
    }

    private static void printLine(int i) {

    }

    private static void validateInput(int n) {
        Set<Integer> validNumbers = new HashSet<Integer>(10);
        for (int i = 0; i <= 10; i++) {
            validNumbers.add(3 * (int)Math.pow(2, i));
        }
        if (!validNumbers.contains(n)) {
            throw new IllegalArgumentException(n + " is invalid number.");
        }
    }
}