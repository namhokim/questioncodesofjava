package com.example.springboot.sandbox.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fruit implements Cloneable {
    private String name;
    private Color color;
    private int quantity;

    @Override
    public String toString() {
        return quantity + "개의 " + color.toString() + " " + name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Fruit clone = (Fruit)super.clone();
        clone.setName(this.name);
        clone.setColor(this.color);
        clone.setQuantity(this.quantity);
        return clone;
    }

    public enum Color {
        RED("빨간"),
        GREEN("녹색"),
        YELLOW("노랑");

        Color(String name) {
            this.name = name;
        }

        @Getter
        private String name;

        @Override
        public String toString() {
            return name;
        }
    }
}
