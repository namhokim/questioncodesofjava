package com.naver.cafe.javachobostudy.wnckszzz

import spock.lang.Specification

class StaticInitializationBlockTest extends Specification {
    def "findByLocation"() {
        when:
        StaticInitializationBlock block
        100000000.times {
            block = StaticInitializationBlock.findByLocation("block")
        }

        then:
        block == StaticInitializationBlock.INITIALIZATION_BLOCK
    }

    def "findByLocation2"() {
        when:
        StaticInitializationBlock block
        100000000.times {
            block = StaticInitializationBlock.findByLocation2("block")
        }

        then:
        block == StaticInitializationBlock.INITIALIZATION_BLOCK
    }
}
