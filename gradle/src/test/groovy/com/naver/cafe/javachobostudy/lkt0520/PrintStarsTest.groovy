package com.naver.cafe.javachobostudy.lkt0520

import spock.lang.Specification

class PrintStarsTest extends Specification {
    private static final COUNT = 100_000

    def "Display"() {
        when:
        def result = PrintStars.display(COUNT, '*' as char)

        then:
        result.toString().length() == COUNT
    }

    def "Display2"() {
        when:
        def result = PrintStars.display2(COUNT, '*' as char)

        then:
        result.length() == COUNT
    }
}
