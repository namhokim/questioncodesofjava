package com.example.springboot.sandbox.naver.lkt0520;

public class A000 {
    public static void main(String[] args) {
        int flag = 1; int i = 1;int num = 0, sum = 0;
        for( sum = 0, flag = 1, i = 1;  ; i++,flag=-flag) {
            num = i*flag;
            sum = sum + num;
            if(sum == 100) { break; }
        }
        System.out.println(num + "/" + sum);
    }
}
