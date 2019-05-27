package com.example.springboot.sandbox.me

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import spock.lang.Specification

class ItemDateTest extends Specification {
    def "getter로 가져와서 변경하면 필드의 값도 같이 바뀐다."() {
        given: "임의의 아이템을 생성한다."
        def cut = new ItemDate(1, "sample", "namo", new Date())

        and: "getter를 이용해서 지역 변수에 담는다."
        Date date = cut.getCreateAt()

        when: "date를 하루전 날짜로 돌려놓았으면"
        date.setDate(date.getDate() - 1)

        then: "멤버의 값은 변경되지 않아야 한다."
        date != cut.getCreateAt()
    }

    def "Gson으로 JSON으로 변환한다."() {
        given: "임의의 아이템을 생성한다."
        def item = new ItemDate(1, "sample", "namo", new Date())

        and:
        Gson gson = getGsonWithTypeAdapter()

        when:
        String json = gson.toJson(item)

        then:
        json == '{"id":1,"name":"sample","createBy":"namo","createAt":"May 15, 2019 10:55:06 AM"}'
    }

    Gson getGsonWithBuilder() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create()
    }

    Gson getGsonWithTypeAdapter() {
        return new GsonBuilder().registerTypeAdapter(Date.class, new GsonDateConverter()).create()
    }

    def "Jackson으로 JSON으로 변환한다."() {
        given: "임의의 아이템을 생성한다."
        def item = new ItemDate(1, "sample", "namo", new Date())

        and:
        ObjectMapper objectMapper = new ObjectMapper()

        when:
        String json = objectMapper.writeValueAsString(item)

        then:
        json == '{"id":1,"name":"sample","createBy":"namo","createAt":1557885389440}'
    }
}
