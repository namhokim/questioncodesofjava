package naver.goharrm;

public class Scope {
    private int a;

    public int getA() {
        return ++a;
    }

    public static void main(String[] args) {
        Scope scope = new Scope();
        scope.a = 2;
        System.out.println(scope.getA());
    }
}

class Another {
    public static void main(String[] args) {
        Scope scope = new Scope();
        //scope.a = 2;
        System.out.println(scope.getA());
    }
}