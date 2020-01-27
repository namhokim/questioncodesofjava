package com.example.springboot.sandbox.converters

import com.example.springboot.sandbox.domain.adg0609.ApResponse
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class ApResponseConverterSpec extends Specification {
    @Subject
    private ApResponseConverter sut

    private ObjectMapper objectMapper

    def setup() {
        objectMapper = new ObjectMapper()
        sut = new ApResponseConverter(objectMapper)
    }

    @Unroll
    def "#text will convert to #expectedResult"() {
        when:
        ApResponse result = sut.convert(text)

        then:
        result.pages == expectedResult

        where:
        text                  || expectedResult
        '{"pages":[1,2,3,4]}' || [1, 2, 3, 4]
    }
}
