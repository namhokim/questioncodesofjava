package com.example.springboot.sandbox.devhaja.nyong;

public class V2 extends Base {

    private final String d;
    private final String bbb;


    public static class Builder extends Base.Builder<Builder> {
        private String d;

        public Builder() {
        }

        public Builder setD(String d) {
            this.d = d;
            return this;
        }

        @Override
        public V2 build() {
            return new V2(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public String makeString() {
            return this.getA();
        }

    }

    public V2(Builder builder) {
        super(builder);
        this.d = builder.d;
        this.bbb = builder.getB();
    }
}
