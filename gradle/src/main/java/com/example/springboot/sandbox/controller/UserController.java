package com.example.springboot.sandbox.controller;

import com.example.springboot.sandbox.exception.UserAlreadyExistsException;
import com.example.springboot.sandbox.model.User;
import com.example.springboot.sandbox.repository.MemberProjection;
import com.example.springboot.sandbox.repository.MemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
public class UserController {

    private final MemberRepository memberRepository;

    public UserController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/user")
    public String user(@Valid User user) {
        throw new UserAlreadyExistsException(user.getUsername());
    }

    @GetMapping("/user-phones")
    public MemberProjection userPhones(@NotBlank @Valid String name) {
        final MemberProjection telephoneProjectionBy = memberRepository.getTelephoneProjectionByNative(name);
        return telephoneProjectionBy;
    }

}
