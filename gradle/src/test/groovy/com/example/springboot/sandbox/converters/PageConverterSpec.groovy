package com.example.springboot.sandbox.converters


import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class PageConverterSpec extends Specification {
    @Subject
    private PageConverter sut

    private ObjectMapper objectMapper

    def setup() {
        objectMapper = new ObjectMapper()
        sut = new PageConverter(objectMapper)
    }

    @Unroll
    def "#text will convert to #expectedResult"() {
        when:
        Integer[] result = sut.convert(text)

        then:
        result == expectedResult

        where:
        text        || expectedResult
        '[1,2,3,4]' || [1, 2, 3, 4] as Integer[]
    }
}
