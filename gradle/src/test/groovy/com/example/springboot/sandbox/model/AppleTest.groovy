package com.example.springboot.sandbox.model

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import spock.lang.Specification

class AppleTest extends Specification {
    def "Gson"() {
        given:
        def apple = new Apple()
        apple.color = "red"
        apple.radius = 3

        and:
        def gson = new Gson()

        when:
        def result = gson.toJson(apple)

        then:
        result == '''{"color":"red","radius":3}'''
    }

    def "Jackson"() {
        given:
        def apple = new Apple()
        apple.color = "red"
        apple.radius = 3

        and:
        def mapper = new ObjectMapper()

        when:
        def result = mapper.writeValueAsString(apple)

        then:
        result == '''{"color":"red","radius":3}'''
    }
}
