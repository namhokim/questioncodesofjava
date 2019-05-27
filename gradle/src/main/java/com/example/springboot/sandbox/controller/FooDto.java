package com.example.springboot.sandbox.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class FooDto {
    @NotBlank(message = "우편번호를 작성해주세요.")
    @Pattern(regexp = "[0-9]{5}", message = "5자리의 숫자만 입력가능합니다")
    private String zipcode;
}
