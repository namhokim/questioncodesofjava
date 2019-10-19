package com.naver.cafe.javachobostudy.g2040g;

//편의점 클래스 정의 Goods class
public class Goods {
    private String category; //대분류 이름
    private int code = 0; //물품번호 부여
    private String name; //제품명
    private int price; //가격
    private int stock;//재고 수량

    public Goods(String cate, String n, int p, int s) {//생성자
        this.category = cate;
        this.name = n;
        this.price = p;
        this.stock = s;
        code++;//코드 증가
    }

    //접근자 변경자 함수
    String getCategory() {
        return category;
    }

    void setCategory(String cate) {
        category = cate;
    }

    String getName() {
        return name;
    }

    void setName(String n) {
        name = n;
    }

    int getPrice() {
        return price;
    }

    void setPrice(int p) {
        price = p;
    }

    int getStock() {
        return stock;
    }

    void setStock(int s) {
        stock = s;
    }

    int getCode() {
        return code;
    }

    void setCode(int c) {
        code = c;
    }

    //재고를 더하고 빼는 기능을 하는 함수들
    public void addStock(int stock) { // 재고를 더함
        this.stock += stock;
    }

    public void subStock(int stock) throws Exception { // 재고를 뺌
        if (this.stock == 0)
            throw new Exception("재고가 부족합니다.");
        this.stock -= stock;
    }

}
