package com.example.springboot.sandbox.me

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class ObjectsSpec extends Specification {
    @Subject
    private Sample cut

    def setup() {
        cut = new Sample()
    }

    @Unroll
    def '문자열의 비교: before("#str1" , "#str2") == #expectResult'() {
        when:
        def result = cut.before(str1, str2)

        then:
        result == expectResult

        where:
        str1   | str2   | expectResult
        null   | null   | false
        null   | "str2" | false
        "str1" | null   | false
        "str1" | "str2" | false
        "str"  | "str"  | true
    }

    @Unroll
    def '문자열의 비교: later("#str1" , "#str2") == #expectResult'() {
        when:
        def result = cut.later(str1, str2)

        then:
        result == expectResult

        where:
        str1   | str2   | expectResult
        null   | null   | false
        null   | "str2" | false
        "str1" | null   | false
        "str1" | "str2" | false
        "str"  | "str"  | true
    }
}
