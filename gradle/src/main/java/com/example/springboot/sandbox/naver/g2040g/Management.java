package com.example.springboot.sandbox.naver.g2040g;

import java.io.Serializable;

//편의점 클래스 정의 Management class
public class Management {
    private int manageSize = 0;//배열에 들어있는 객체 개수
    private Goods[] goods = new Goods[100];//물품 배열 선언


    public void insertGoods(Goods newGoods) throws Exception { // 물품 리스트에 물품 객체 삽입
        goods[manageSize++] = newGoods;    // 전체 물품 종류 수 증가
        if (manageSize == 100) {//저장 물품이 100개가 됐을 때
            throw new Exception("최대 물품 수를 초과했습니다.");
        }
    }

    public void changeGoods(Goods newGoods, int change_num) {//물품 수정
        goods[change_num] = newGoods;
    }

    public String printGoods(int i) {//물품 목록 출력
        return "물품 카테고리: " + goods[i].getCategory() + " 물품명 : " + goods[i].getName() + " 물품 가격 : " + goods[i].getPrice() + " 물품 재고 : " + goods[i].getStock();

    }

    //manageSize접근자 변경자
    int getManageSize() {//접근자
        return manageSize;
    }

    void setManageSize(int size) {//변경자
        manageSize = size;
    }

    public int findGoodsIndex(String goodsName) throws Exception {//삭제할 인덱스 찾기
        int goodsIndex = 0;//인덱스
        boolean find = false;//물품 찾았는지
        for (int i = 0; i < manageSize; i++) {
            if (goodsName.equals(goods[i].getName())) {
                goodsIndex = i;
                find = true; //물품 찾음
                break;
            }
        }
        if (!find) {
            throw new Exception("찾는 물품이 없습니다.");//찾는 물품이 없을 때
        }
        return goodsIndex;
    }


    public void deleteGoods(int index) {//물품 삭제
        //한칸씩 밀기
        if (manageSize - index >= 0) System.arraycopy(goods, index + 1, goods, index, manageSize - index);
        manageSize--;////삭제하기
    }

    public Goods[] findGoodsCategory(String categoryName) throws Exception {//카테고리 찾아줌
        boolean find = false; //대분류 찾았는지
        Goods[] findGoods = new Goods[manageSize]; //반환할 배열
        for (int i = 0; i < manageSize; i++) {
            if (categoryName.equals(goods[i].getCategory())) {//찾는 대분류=물품 대분류
                findGoods[i] = goods[i]; //찾는것과 같다
                find = true;//찾았음
            }
        }
        if (!find) {//못찾았을 때
            throw new Exception("찾는 카테고리가 없습니다.");
        }
        return findGoods; //배열 반환
    }

    public int sellEstimate(int index, int sellCount) throws Exception {//구매 이전의 값을 찾아주는 함수
        if (sellCount > goods[index].getStock()) {
            throw new Exception("재고는 " + goods[index].getStock() + "뿐입니다." + "물품 구매를 종료하도록 하겠습니다.");
        }
        return goods[index].getStock();//구매 이전의 물품 재고
    }

    public int sell(int index, int sellCount) throws Exception {//구매를 행하는 함수
        int payment;    //지불 금액
        if (sellCount > goods[index].getStock()) {//재고가 없을 때
            throw new Exception("재고가 부족해서 구매를 진행할 수 없습니다.");
        } else {
            payment = (goods[index].getPrice() * sellCount);//지불 금액
            int subCount = goods[index].getStock() - sellCount;//구매 후 물품 수량
            goods[index].setStock(subCount);
            if (subCount == 0) {//재고 다 썼을 때
                deleteGoods(index);//물품 삭제
            }
        }
        return payment; //지불 금액 반환하기
    }
}

