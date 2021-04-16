package io.aha.detailiguana;

public class CodeRunner {
    public static void main(String[] args){
        String contents = "나는 오늘도 회사에 가야 한다.";
        String result = wrap(contents);

        //출력
        System.out.println(result);
    }

    public static String wrap(String contents) {
        // 문장을 공백을 기준으로 배열로 변환
        String[] strArr = contents.split(" ");
        // 출력 String 선언
        String result = null;

        for (int i = 0; i < strArr.length; i++) {
            String str = null;
            // 단어 배열을 돌면서 마지막 2단어일경우 단어에 대괄호 추가
            if (strArr.length - 3 < i) {
                str = "[" + strArr[i] + "]";
            } else {
                str = strArr[i];
            }
            // 변경된 단어 배열 재조합
            result = result == null ? str : result + " " + str;
        }
        return result;
    }
}
