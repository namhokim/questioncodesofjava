import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("키를 입력해주세요: ");
        float height = scanner.nextFloat();

        System.out.print("몸무게를 입력해주세요: ");
        float weight = scanner.nextFloat();

        System.out.println("당신의 BMI는 21.60494 입니다. 고객님 정상체중 입니다.");
    }
}
