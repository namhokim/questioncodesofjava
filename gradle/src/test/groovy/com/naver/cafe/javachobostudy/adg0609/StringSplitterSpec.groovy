package com.naver.cafe.javachobostudy.adg0609

import spock.lang.Specification
import spock.lang.Unroll

class StringSplitterSpec extends Specification {
    @Unroll
    def "#text will split to #expectedResult"() {
        when:
        Integer[] result = StringSplitter.splitNumbers(text)

        then:
        result == expectedResult

        where:
        text        || expectedResult
        "1,2,3,4"   || [1, 2, 3, 4] as Integer[]
        "[1,2,3,4]" || [1, 2, 3, 4] as Integer[]
        "[1,2,3,4"  || [1, 2, 3, 4] as Integer[]
        "1,2,3,4]"  || [1, 2, 3, 4] as Integer[]
        "]1,2,3,4[" || [1, 2, 3, 4] as Integer[]
    }
}
