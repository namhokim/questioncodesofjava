package com.example.springboot.sandbox.me

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import spock.lang.Specification

import java.time.LocalDateTime

class ItemLocalDateTimeTest extends Specification {

    def "getter로 가져와서 변경하면 필드의 값도 같이 바뀐다."() {
        given: "임의의 아이템을 생성한다."
        def cut = new ItemLocalDateTime(1, "sample", "namo", LocalDateTime.now())

        and: "getter를 이용해서 지역 변수에 담는다."
        LocalDateTime date = cut.getCreateAt()

        when: "date를 하루전 날짜로 돌려놓았으면"
        date = date.minusDays(1)

        then: "멤버의 값은 변경되지 않아야 한다."
        date != cut.getCreateAt()
    }

    def "Gson으로 JSON으로 변환한다."() {
        given: "임의의 아이템을 생성한다."
        def item = new ItemLocalDateTime(1, "sample", "namo", LocalDateTime.now())

        and:
        Gson gson = new Gson()

        when:
        String json = gson.toJson(item)

        then:
        json == '{"id":1,"name":"sample","createBy":"namo","createAt":{"date":{"year":2019,"month":5,"day":15},"time":{"hour":10,"minute":57,"second":11,"nano":837000000}}}'
    }

    def "Jackson으로 JSON으로 변환한다."() {
        given: "임의의 아이템을 생성한다."
        def item = new ItemLocalDateTime(1, "sample", "namo", LocalDateTime.now())

        and:
        ObjectMapper objectMapper = new ObjectMapper()

        when:
        String json = objectMapper.writeValueAsString(item)

        then:
        json == '{"id":1,"name":"sample","createBy":"namo","createAt":{"second":25,"dayOfYear":135,"year":2019,"month":"MAY","dayOfMonth":15,"dayOfWeek":"WEDNESDAY","monthValue":5,"hour":10,"minute":57,"nano":679000000,"chronology":{"id":"ISO","calendarType":"iso8601"}}}'
    }
}
