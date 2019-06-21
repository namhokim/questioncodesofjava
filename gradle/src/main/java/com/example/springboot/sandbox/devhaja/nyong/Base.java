package com.example.springboot.sandbox.devhaja.nyong;

public class Base {
    private String a;
    private String b;
    private String c;

    abstract static class Builder<T extends Builder<T>> {
        private String a;
        private String b;
        private String c;

        public String getA() {
            return a;
        }

        public String getB() {
            return b;
        }

        public String getC() {
            return c;
        }

        public T setA(String a) {
            this.a = a;
            return self();
        }

        public T setB(String b) {
            this.b = "b";
            return self();
        }

        public T setC(String c) {
            this.c = c;
            return self();
        }

        abstract Base build();

        protected abstract T self();

        abstract String makeString();
    }

    Base(Builder<?> builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }
}
