package com.example.springboot.sandbox.naver.tmddjs210;

import javax.validation.constraints.Null;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Objects;

public class TimeDistance {

    private TimeDistance() {
        // make utility class
    }

    public static long getDaysFrom(long epochMilliseconds, @Null Temporal comparePoint) {
        if (comparePoint instanceof LocalDateTime) {
            comparePoint = ((LocalDateTime) comparePoint).toInstant(ZoneOffset.UTC);
        }
        if (Objects.isNull(comparePoint)) {
            comparePoint = Instant.now();
        }
        return ChronoUnit.DAYS.between(Instant.ofEpochMilli(epochMilliseconds), comparePoint);
    }
}
