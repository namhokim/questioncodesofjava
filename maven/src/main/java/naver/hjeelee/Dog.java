package naver.hjeelee;

public class Dog extends Animal implements Mammalia  {
    @Override
    public void sound() {
        System.out.println("mung");
    }

    @Override
    public void sleep() {
        System.out.println("zzzz");
    }

    @Override
    public void feed() {
        System.out.println("chok chok");
    }
}
