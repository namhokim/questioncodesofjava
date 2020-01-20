package com.naver.cafe.javachobostudy.ink_young;

import java.util.*;

public class Vocabulary {

    public static final int ADD_WORD = 1;
    public static final int SHOW_WORDS_LIST = 2;
    public static final int CHANGE_WORD = 3;
    public static final int FIND_WORDS = 4;

    public static void main(String[] args) {
        ArrayList<String> vocabularies = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("======영어단어장======");

        while (true) {
            System.out.println("1.단어추가 / 2.목록보기 / 3.단어수정 / 4.단어검색");
            try {
                String command = sc.nextLine();
                int number = Integer.parseInt(command);
                switch (number) {
                    case ADD_WORD:
                        System.out.println("추가할 단어를 입력하세요");
                        String word = sc.nextLine();
                        vocabularies.add(word);
                        break;
                    case SHOW_WORDS_LIST:
                        Collections.sort(vocabularies);
                        for (String s : vocabularies) {
                            System.out.println(s);
                        }
                        break;
                    case CHANGE_WORD:
                        for (String vocabulary : vocabularies) {
                            System.out.println(vocabulary + ",");
                        }
                        System.out.println("\n위의 단어들 중에서 고치고 싶은 단어를 입력하세요");
                        String change = sc.nextLine();
                        System.out.println("수정하세요.");
                        String change2 = sc.nextLine();
                        System.out.println(change + "가" + change2 + "로 변경되었습니다.");
                        vocabularies.remove(change);
                        vocabularies.add(change2);
                        break;
                    case FIND_WORDS:
                        System.out.println("단어를 검색해 봅시다. 입력해보세요.");
                        String searchWords = sc.nextLine();
                        if (!searchWords.isEmpty()) {
                            String[] targets = searchWords.split(" ");
                            for (String vocabulary : vocabularies) {
                                for (String target : targets) {
                                    if (vocabulary.startsWith(target)) {
                                        System.out.println(vocabulary);
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("제대로 입력하세요 \n");
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자의 입력이 필요합니다.");
            }
        }
    }
}
