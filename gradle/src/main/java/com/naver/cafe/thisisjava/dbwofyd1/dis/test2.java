package com.naver.cafe.thisisjava.dbwofyd1.dis;

public class test2 {
    int gas;

    void setGas(int g) {
        this.gas = g;
    }

    boolean isLeftGas() {
        if(gas==0) {
            System.out.println("gas가 없습니다.");
            return false;
        }
        System.out.println("gas가 있습니다.");
        return true;
    }

    void run() {
        while (true) {
            if(gas>0) {
                System.out.println("달립니다. (gas 잔량: " + gas + ")");
                gas -= 1;
            }
            else {
                System.out.println("멈춥니다. (gas 잔량: " + gas + ")");
                return;
            }
        }
    }
}
