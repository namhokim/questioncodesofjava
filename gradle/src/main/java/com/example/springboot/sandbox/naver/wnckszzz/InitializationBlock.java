package com.example.springboot.sandbox.naver.wnckszzz;

public class InitializationBlock extends ParentClass{
    private String member;

    public InitializationBlock() {
        System.err.println("Constructor");
        member = "constructor";
    }

    public InitializationBlock(String member) {
        this.member = member;
    }

    {
        System.err.println("InitializationBlock");
        member = "initialization block";
    }

    public static void main(String[] args) {
        InitializationBlock ib = new InitializationBlock();
        System.out.println(ib.member);
    }
}
