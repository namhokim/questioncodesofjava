package com.naver.cafe.thisisjava.ljyeon0713;

public class ConstantModifier {
    private static int foo;
    private final int boo;
    private static final int DOO;

    static {
        DOO = 5;
    }

    public ConstantModifier() {
        ConstantModifier.foo = 1;
        this.boo = 2;
//        DOO = 3;
    }

    public static void main(String[] args) {
        ConstantModifier constantModifier = new ConstantModifier();
        System.out.println(constantModifier);
    }
}
