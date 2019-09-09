package com.example.springboot.sandbox.naver.tmddjs210

import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDateTime

class TimeDistanceTest extends Specification {
    @Unroll
    def "getDaysFrom : #epochTime ~ #comparePoint : #expectedDay"() {
        when:
        long days = TimeDistance.getDaysFrom(epochTime, comparePoint)

        then:
        days == expectedDay

        where:
        epochTime      | comparePoint                         || expectedDay
        1551500880000L | LocalDateTime.of(2019, 3, 4, 13, 20) || 2
        1551500880000L | LocalDateTime.of(2019, 3, 5, 13, 20) || 3
        1551500880000L | LocalDateTime.of(2019, 3, 5, 13, 20) || 3
    }
}
