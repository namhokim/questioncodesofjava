package com.example.springboot.sandbox.naver.tmddjs210;

import javax.validation.constraints.Null;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class TimeDistance {
    public static void main(String[] args) {
        long pastEpoch = 1551500880000L;    //  2019년 3월 2일 13시 20분 타임스탬프
        LocalDateTime point = LocalDateTime.of(2019, 3, 4, 13, 20);
        final long days = getDaysFrom(pastEpoch, point);
        System.out.printf("%d일 지났습니다%n", days);
    }

    public static long getDaysFrom(long epochMilliseconds, @Null LocalDateTime comparePoint) {
        final Duration duration = Duration.ofMillis(epochMilliseconds);
        LocalDateTime before = LocalDateTime.ofEpochSecond(duration.getSeconds(), duration.getNano(), ZoneOffset.UTC);
        if (Objects.isNull(comparePoint)) {
            comparePoint = LocalDateTime.now();
        }
        return ChronoUnit.DAYS.between(before, comparePoint);
    }
}
