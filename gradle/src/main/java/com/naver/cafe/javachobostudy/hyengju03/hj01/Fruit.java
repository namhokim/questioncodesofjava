package com.naver.cafe.javachobostudy.hyengju03.hj01;

public abstract class Fruit {
    public void print() {
        System.out.println("나는 " + getProduct() + "이다.");
    }

    protected abstract String getProduct();
}

class Grape extends Fruit {
    @Override
    protected String getProduct() {
        return "포도";
    }
}

class Apple extends Fruit {
    @Override
    protected String getProduct() {
        return "사과";
    }
}

class Pear extends Fruit {
    @Override
    protected String getProduct() {
        return "배";
    }
}

class Ch05 {
    public static void main(String[] args) {
        Fruit[] fAry = {new Grape(), new Apple(), new Pear()};
        for (Fruit f : fAry) {
            f.print();
        }
    }
}
