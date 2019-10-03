package com.example.springboot.sandbox.naver.hhs9102;

import lombok.Getter;

import java.time.LocalDateTime;

public class LocalDateTimeNullCheck {
    public static void main(String[] args) {
        @Getter
        class LocalDateTimeExample {
            LocalDateTime start = LocalDateTime.of(2019,1,1,12,0, 0);
            LocalDateTime end = LocalDateTime.of(2015,1,1,12,0, 0);
            LocalDateTime none;
        }
        LocalDateTimeExample localDateTimeExample = new LocalDateTimeExample();

        if(localDateTimeExample.getNone().isBefore(localDateTimeExample.start)){
            System.out.println("It is wrong.");
        }
    }
}
