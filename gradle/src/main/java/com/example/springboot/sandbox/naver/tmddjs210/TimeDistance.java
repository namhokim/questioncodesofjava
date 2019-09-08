package com.example.springboot.sandbox.naver.tmddjs210;

import javax.validation.constraints.Null;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class TimeDistance {

    private TimeDistance() {
        // make utility class
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
