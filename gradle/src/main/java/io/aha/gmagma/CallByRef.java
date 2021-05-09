package io.aha.gmagma;

public class CallByRef {
    private final int[] ref1;

    public CallByRef(int[] ref1) {
        this.ref1 = ref1;
    }

    public void increase() {
        for (int i = 0; i < ref1.length; i++) {
            ref1[i]++;
        }
    }

    public void printValues() {
        for (int i = 0; i < ref1.length; i++) {
            System.out.println("ref1[" + i + "] : " + ref1[i]);
        }
    }

    public static void main(String[] args) {
        int[] data = {100, 800, 1000};
        CallByRef ref = new CallByRef(data);
        ref.printValues();
        ref.increase();
        System.out.println();
        ref.printValues();
    }

}
