package com.naver.cafe.javachobostudy.ink_young;

import java.util.List;
import java.util.Scanner;

public class VocabularyLauncher {
    enum VocabularyLauncherMenu {
        ADD_WORD(1),
        SHOW_WORDS_LIST(2),
        CHANGE_WORD(3),
        FIND_WORDS(4);

        private int menuCode;

        VocabularyLauncherMenu(int code) {
            this.menuCode = code;
        }

        static VocabularyLauncherMenu parseMenu(String code) {
            try {
                int number = Integer.parseInt(code);
                for (VocabularyLauncherMenu menu : VocabularyLauncherMenu.values()) {
                    if (menu.menuCode == number) {
                        return menu;
                    }
                }
                throw new IllegalArgumentException("숫자의 입력이 필요합니다.");
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("숫자의 입력이 필요합니다.");
            }
        }
    }

    public static void main(String[] args) {
        Vocabulary vocabulary = new Vocabulary();

        Scanner sc = new Scanner(System.in);
        System.out.println("======영어단어장======");

        while (true) {
            System.out.println("1.단어추가 / 2.목록보기 / 3.단어수정 / 4.단어검색");
            try {
                String command = sc.nextLine();
                VocabularyLauncherMenu menu = VocabularyLauncherMenu.parseMenu(command);
                switch (menu) {
                    case ADD_WORD:
                        System.out.println("추가할 단어를 입력하세요");
                        String word = sc.nextLine();
                        vocabulary.add(word);
                        break;
                    case SHOW_WORDS_LIST:
                        vocabulary.showTo(System.out);
                        break;
                    case CHANGE_WORD:
                        vocabulary.showTo(System.out);
                        System.out.println("\n위의 단어들 중에서 고치고 싶은 단어를 입력하세요");
                        String change = sc.nextLine();
                        System.out.println("수정하세요.");
                        String change2 = sc.nextLine();
                        vocabulary.change(change, change2);
                        System.out.println(change + "가" + change2 + "로 변경되었습니다.");
                        break;
                    case FIND_WORDS:
                        System.out.println("단어를 검색해 봅시다. 입력해보세요.");
                        String searchWords = sc.nextLine();
                        if (!searchWords.isEmpty()) {
                            String[] targets = searchWords.split(" ");
                            final List<String> searchResult = vocabulary.search(targets);
                            for (String result : searchResult) {
                                System.out.println(result);
                            }
                        }
                        break;
                    default:
                        System.out.println("제대로 입력하세요 \n");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
