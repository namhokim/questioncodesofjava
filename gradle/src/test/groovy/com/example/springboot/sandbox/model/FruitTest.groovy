package com.example.springboot.sandbox.model

import spock.lang.Specification

class FruitTest extends Specification {
    def "Fruit의 toString()을 호출하면 색상과 이름과 수량이 출력된다."() {
        given:
        def apple = "Fruit 객체를 apple이라는 이름으로 생성한다."()

        when: "apple의 toString 메서드를 호출한다."
        String result = apple.toString()

        then: "결과는 '2개의 빨간 사과'라고 나온다."
        result == "2개의 빨간 사과"
    }

    def "Fruit의 clone()을 호출하면 동일한 속성을 가진 객체로 복제가 된다."() {
        given:
        def apple = "Fruit 객체를 apple이라는 이름으로 생성한다."()

        when: "apple의 clone 메서드를 호출한다."
        Fruit resultOfAnotherApple = (Fruit)apple.clone()

        then:
        '결과는 만든 객체와 값과 동일하며 두 객체는 다르다.'(apple, resultOfAnotherApple)
    }

    private Fruit "Fruit 객체를 apple이라는 이름으로 생성한다."() {
        def apple = new Fruit()
        apple.with {
            (name, color, quantity) = ["사과", Fruit.Color.RED, 2]
        }
        return apple
    }

    private void '결과는 만든 객체와 값과 동일하며 두 객체는 다르다.'(Fruit original, Fruit cloned) {
        with(cloned) {
            name == original.name
            color == original.color
            quantity == original.quantity
        }
        assert cloned != original
    }
}
