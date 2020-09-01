package com.naver.cafe.thisisjava.dbwofyd1.dis;

public class test {
    public static void main(String[] args) {
        test2 myCar = new test2();

        myCar.setGas(5);

        boolean gasState = myCar.isLeftGas();
        if(gasState) {
            System.out.println("출발");
            myCar.run();
        }

        if(myCar.isLeftGas()) {
            System.out.println("gas를 주입할 필요가 없습니다.");
        }
        else {
            System.out.println("gas를 주입해주세요.");
        }
    }
}
