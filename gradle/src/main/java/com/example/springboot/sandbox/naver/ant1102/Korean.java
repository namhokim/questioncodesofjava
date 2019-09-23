package com.example.springboot.sandbox.naver.ant1102;

public class Korean {
    private String name;
    private String ssn;

    public Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public static void main(String[] args) {
        Korean k1 = new Korean("박선영", "123311");
        System.out.println("k1.name :" + k1.name);
        System.out.println("k1.ssn :" + k1.ssn);
    }
}
