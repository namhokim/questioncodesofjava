package com.example.springboot.sandbox.devhaja.nyong;

public class V3 extends Base {

    private final String e;

    public static class Builder extends Base.Builder<Builder> {
        private String e;

        public Builder() {
        }

        public Builder setE(String e) {
            this.e = e;
            return this;
        }

        @Override
        public V3 build() {
            return new V3(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        String makeString() {
            return this.getA();
        }

    }

    private V3(Builder builder) {
        super(builder);
        this.e = builder.e;
    }
}
