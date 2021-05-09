package io.aha.gmagma;

public class Accumulator {
    private int sum = 0;

    public int getSum() {
        return sum;
    }

    public void add(int value) {
        sum += value;
    }

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        accumulator.add(100);
        accumulator.add(150);
        int sum = accumulator.getSum();
        System.out.println(sum);
    }

}
