package com.example.springboot.sandbox.me;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TypeEraserTester<T> {
    private final TypeToken<List<T>> internalTypeToken = new TypeToken<List<T>>() { };

    private void test(Class<?> clazz) {
        final TypeToken<List<Foo>> typeTokenWithExtended = new TypeToken<List<Foo>>() {
        };
        final TypeToken byParameter = TypeToken.getParameterized(List.class, clazz);

        final Type typeWithoutExtended = internalTypeToken.getType();
        final Type typeWithExtended = typeTokenWithExtended.getType();
        final Type typeWithArgument = byParameter.getType();

        System.out.println(typeWithoutExtended.getTypeName());
        System.out.println(typeWithExtended.getTypeName());
        System.out.println(typeWithArgument.getTypeName());
    }

    public static void main(String[] args) {
        TypeEraserTester<List<Foo>> tester = new TypeEraserTester<>();
        tester.test(Foo.class);

    }
}

class Foo {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
