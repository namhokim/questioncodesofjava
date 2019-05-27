package com.example.springboot.sandbox.model

import spock.lang.Specification
import spock.lang.Subject

class AdderTest extends Specification {
    @Subject Adder cut

    def "add: 1 + 2 = 3"() {
        given:
        cut = new Adder(1)

        when:
        cut.add(2)

        then:
        cut.getNumber() == old(cut.getNumber()) + 2
    }
}
