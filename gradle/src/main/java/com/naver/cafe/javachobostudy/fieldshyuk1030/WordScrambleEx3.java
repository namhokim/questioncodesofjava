package com.naver.cafe.javachobostudy.fieldshyuk1030;

import java.util.Scanner;

public class WordScrambleEx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuizWord quizWord = new QuizWord();
        QuizWord.Quiz quiz = quizWord.pickQuiz();
        while (true) {
            System.out.println("Question :" + quiz.getScrambledWord());
            System.out.print("Your answer is :");

            String answer = sc.nextLine().trim();
            if (answer.equalsIgnoreCase("q")) {
                break;
            }

            if (answer.equalsIgnoreCase(quiz.getAnswer())) {
                System.out.println("정답입니다.");
                quiz = quizWord.pickQuiz();
            } else {
                System.out.println(answer + "은/는 정답이 아닙니다. 다시 시도해보세요.");
            }
        }
    }
}

class QuizWord {
    private static final String[] WORDS = {"CHANGE", "LOVE", "HOPE", "VIEW"};

    Quiz pickQuiz() {
        int idx = (int) (Math.random() * WORDS.length);

        return Quiz.of(WORDS[idx], getScrambledWord(WORDS[idx]));
    }

    private String getScrambledWord(String str) {
        char[] chArr = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            int idx = (int) (Math.random() * str.length());

            char tmp = chArr[i];
            chArr[i] = chArr[idx];
            chArr[idx] = tmp;
        }
        return new String(chArr);
    }

    static class Quiz {
        private String answer;
        private String scrambledWord;

        private Quiz(String answer, String scrambledWord) {
            this.answer = answer;
            this.scrambledWord = scrambledWord;
        }

        String getAnswer() {
            return answer;
        }

        String getScrambledWord() {
            return scrambledWord;
        }

        public static Quiz of(String answer, String scrambledWord) {
            return new Quiz(answer, scrambledWord);
        }
    }
}
