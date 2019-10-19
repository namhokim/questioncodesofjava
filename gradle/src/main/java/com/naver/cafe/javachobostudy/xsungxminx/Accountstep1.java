package com.naver.cafe.javachobostudy.xsungxminx;

public class Accountstep1 {
    private String accountNumber;
    private String accountHolder;
    private int balance;

    public Accountstep1(String accountNumber, String accountHolder, int initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;

        System.out.printf("계좌 %s(예금주 : %s)%n", accountNumber, accountHolder);
        System.out.printf("잔액 : %d원%n", balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.printf("%d 원 입금합니다.%n", amount);
        System.out.printf("잔액 : %d원%n", balance);
    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.printf("%d 원 인출합니다.%n", amount);
        System.out.printf("잔액 : %d원%n", balance);
    }

    public static void main(String[] args) {
        Accountstep1 accountstep = new Accountstep1("123-456789", "홍길동", 10_000);
        accountstep.deposit(20_000);
        accountstep.withdraw(45_000);
    }
}
