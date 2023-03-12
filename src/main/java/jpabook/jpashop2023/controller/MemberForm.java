package jpabook.jpashop2023.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;

@Slf4j
@Getter @Setter
public class MemberForm {
    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
