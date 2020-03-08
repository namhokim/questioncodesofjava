package com.naver.cafe.javachobostudy.ywyi1992;

import lombok.Getter;

@Getter
public class MemberDTO {
    private int id;
    private String name;
    private String address;
    private String addressDetail;
    private String email;
    private String phone;

    public MemberDTO(int id, String name, String s, String tester11, char a,
                     String s1, int i1, String s2, String address, String addressDetail,
                     String email, String phone, char c, String s6, String tester) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.addressDetail = addressDetail;
        this.email = email;
        this.phone = phone;
    }
}
