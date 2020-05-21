package com.example.springboot.sandbox.repository.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(exclude = "member")
public class Phone {
    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

//    @Column(name = "MEMBER_ID")
//    private int memberId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "SEQ")
    private Member member;

    @Column(name = "PHONE_NO")
    private String phoneNo;
}
