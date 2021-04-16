package io.aha.detailiguana;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // 문장을 입력 받기 위해 사용
        Scanner scan = new Scanner(System.in);
        System.out.println("문장을 입력 해 주세요.");

        // 문자열 저장
        String str = scan.nextLine();

        // 출력
        System.out.println(wrap(str));
    }

    public static String wrap(String str) {
        // 문자열이 없으면 종료
        int len = str.length();
        if (len > 0) {
            // 스택에 []를 미리 넣어둠
            Stack<String> stack = new Stack<String>();
            stack.push("[");
            stack.push("]");
            stack.push("[");
            stack.push("]");

            // 문자열을 저장할 변수와 불리언 변수 선언
            StringBuffer sb = new StringBuffer();
            boolean isBlank = false;
            boolean isNeedBraketPop = false;

            // 마지막 문자가 빈칸일 경우를 대비 선언
            if (!" ".equals(str.subSequence(str.length() - 1, str.length()))) {
                sb.append(stack.pop());
                isNeedBraketPop = true;
            }

            // 문자열 길이 만큼 for문을 실행
            for (int i = len - 1; i >= 0; i--) {

                // 뒤에서 부터 문자를 하나씩 가져옴
                String s = str.substring(i, i + 1);

                // 빈칸일 경우
                if (" ".equals(s)) {
                    // 빈칸이 있었음을 저장함.
                    isBlank = true;

                    // 괄호를 한번 pop하여 저장하였을 경우
                    if (isNeedBraketPop == true) {
                        sb.append(stack.pop());
                        sb.append(s);
                        isNeedBraketPop = false;
                    } else {
                        // 괄호를 저장할 필요가 없는 경우
                        sb.append(s);
                    }
                    // 빈칸이 아닐 경우
                } else {
                    // 스택이 비어 있지 않으면서 빈칸이 있었을 경우
                    if (!stack.isEmpty() && isBlank == true) {

                        // 괄호를 저장하고 문자를 저장함.
                        sb.append(stack.pop());
                        sb.append(s);

                        // 상태값을 저장
                        isBlank = false;
                        isNeedBraketPop = true;
                    } else {

                        //문자만 저장
                        sb.append(s);
                    }
                }
            }

            // 2단어 이하일 경우 괄호를 닫아 주어야 한다.
            if (stack.size() % 2 == 1) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }

        return str;
    }
}
