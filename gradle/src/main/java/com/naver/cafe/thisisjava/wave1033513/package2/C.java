package com.naver.cafe.thisisjava.wave1033513.package2;

public class C {
    public C() {
        B b = new B();
        b.field1 = 3;
    }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c);
    }
}

class B {
    public int field1;
}
