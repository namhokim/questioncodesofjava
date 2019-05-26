package naver.rlawlsgur25;

public class Computer_Override extends Calculrator_Override {
    @Override
    double areaCircle(double r) {
        System.out.println("Computer 객체의 arearCircle() 실행");
        return Math.PI * r * r;
    }

    public static void main(String[] args) {
        Calculrator_Override calcurator = new Computer_Override();
        calcurator.areaCircle(10);
    }
}
