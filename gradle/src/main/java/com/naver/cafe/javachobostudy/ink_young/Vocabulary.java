package com.naver.cafe.javachobostudy.ink_young;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Vocabulary {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.println("======영어단어장======");

        while (true) {
        System.out.println("1.단어추가 / 2.목록보기 / 3.단어수정 / 4.단어검색");
        int number = sc.nextInt();
        switch(number) {
            case 1 : // 단어추가
                System.out.println("추가할 단어를 입력하세요");
                String voca = sc.next();
                list.add(voca);
                break;
            case 2 : // 목록보기
                for(int i=0; i< list.size(); i++)
                    System.out.println(list.get(i));
                    Collections.sort(list);
                    break;
        case 3 : // 단어수정
                for(int i=0; i<list.size(); i++)
                    System.out.println(list.get(i) + ",");
                    System.out.println("\n위의 단어들 중에서 고치고 싶은 단어를 입력하세요");
                    String change = sc.next();
                    System.out.println("수정하세요.");
                    String change2 = sc.next();
                    System.out.println(change + "가" + change2 + "로 변경되었습니다.");
                    list.remove(change);
                    list.add(change2);
                    break;
            case 4 : // 단어검색
                ArrayList lsit2 = new ArrayList();
                System.out.println("단어를 검색해 봅시다. 입력해보세요.");
                String findword1 = sc.next();

            default :
                System.out.println("제대로 입력하세요 \n");
        }
        }
    }
}
