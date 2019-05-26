package naver.hjeelee;

public class Chicken extends Animal implements Bird {
    @Override
    public void fly() {
        System.out.println("coco");
    }

    @Override
    public void sound() {
        System.out.println("Coo coo");
    }

    @Override
    public void sleep() {
        System.out.println("chik chik");
    }
}
