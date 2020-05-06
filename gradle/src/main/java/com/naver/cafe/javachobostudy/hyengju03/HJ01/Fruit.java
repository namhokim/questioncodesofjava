package com.naver.cafe.javachobostudy.hyengju03.HJ01;

public abstract class Fruit {
    public String name;
    public void print() {
        System.out.println("나는 " + name + "이다.");
    }
}

class Grape extends Fruit {
    @Override
    public void print() {
        System.out.println("나는 포도이다.");
    }
}

class Apple extends Fruit {
    @Override
    public void print() {
        System.out.println("나는 사과이다.");
    }
}

class Pear extends Fruit {
    @Override
    public void print() {
        System.out.println("나는 배이다.");
    }
}

class ch05 {
    public static void main(String[] args) {
        Fruit fAry[] = {new Grape(), new Apple(), new Pear()};
        for(Fruit f:fAry)
            f.print();
    }
}
