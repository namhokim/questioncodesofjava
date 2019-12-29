package com.naver.cafe.javachobostudy.qlalzl9;

public class Child extends Parent {

    @Override
    public String toString() {
        return "Child";
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        try {
            Child originallyParent = (Child) parent;
            System.out.println(originallyParent);
        } catch (ClassCastException ex) {
            System.out.println(ex);
        }

        Child child = new Child();
        Parent originallyChild = child;
        System.out.println(originallyChild);
    }
}
