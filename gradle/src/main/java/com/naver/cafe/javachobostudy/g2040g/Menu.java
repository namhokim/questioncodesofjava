package com.naver.cafe.javachobostudy.g2040g;

public class Menu {//메뉴

    public static void mainMenu() {//메인 메뉴
        System.out.println("===================편의점 관리 시스템===================");
        System.out.println("1:사용자  2:관리자");
        System.out.println("---------------------------------------------------");
        System.out.print("메뉴 번호를 입력해주세요:");
    }

    /*public static void userMenu() {//사용자 메뉴

    }*/
    public static void manageMenu() {//관리자 메뉴
        System.out.println("●●●●●●●●관리자 모드●●●●●●●●");
        System.out.println("----------------------------------------------------");
        System.out.println("1:물품 등록 2:물품 수정  3:물품 출력  4:물품 삭제 5:물품 검색 0:종료");
        System.out.println("---------------------------------------------------");
        System.out.print("메뉴 번호를 입력해주세요:");
    }
}
