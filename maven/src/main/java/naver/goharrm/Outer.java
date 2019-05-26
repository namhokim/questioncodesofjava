package naver.goharrm;

public class Outer {
    static class StaticInner {
        public static void main(String[] args) {
            System.out.println("main method of Static inner class is running");
        }
    }

    public static void main(String[] args) {
        System.out.println("main method of outer class is running");
    }
}