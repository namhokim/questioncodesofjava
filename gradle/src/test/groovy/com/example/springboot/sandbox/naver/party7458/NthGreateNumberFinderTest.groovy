package com.example.springboot.sandbox.naver.party7458

import spock.lang.Specification
import spock.lang.Unroll

class NthGreateNumberFinderTest extends Specification {
    @Unroll
    def "배열의 수보다 횟수가 작을 경우 -1을 반환한다."() {
        when:
        def result = NthGreateNumberFinder.findO_N(a, b, nTh)

        then:
        result == -1

        where:
        a            | b            | nTh
        [1] as int[] | [2] as int[] | 3
        [1] as int[] | [1] as int[] | 3
        [1] as int[] | [1] as int[] | 4
    }

    def "균형있게 섞여있는 경우"() {
        when:
        def result = NthGreateNumberFinder.findO_N(a, b, nTh)

        then:
        result == expectedResult

        where:
        a                  | b                  | nTh || expectedResult
        [1, 3, 5] as int[] | [2, 4, 7] as int[] | 3   || 4
    }

    def "구역별로 나뉘어 있는 경우"() {
        when:
        def result = NthGreateNumberFinder.findO_N(a, b, nTh)

        then:
        result == expectedResult

        where:
        a                  | b                  | nTh || expectedResult
        [1, 2, 3] as int[] | [5, 6, 7] as int[] | 3   || 5
        [5, 6, 7] as int[] | [1, 2, 3] as int[] | 3   || 5
    }
}
