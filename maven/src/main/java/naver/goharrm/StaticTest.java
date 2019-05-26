package naver.goharrm;

class StaticTest{
    int a = 3;
    static int b = 5;
    public StaticTest() {
        a = a + 3;
        b = b + 3;
    }

    public static void main(String[] args) {
        StaticTest s1 = new StaticTest(); //a:6, b: 8 -> 11
        StaticTest s2 = new StaticTest(); //a:6, b: 11

        System.out.println(s1.a);
        System.out.println(StaticTest.b);     //static field를 객체 참조변수를 통해 접근함

        System.out.println(s2.a);
        System.out.println(StaticTest.b);     //출력결과를 보면 static field이지만 값이 유지되지않고 새로 만들어짐
    }
}