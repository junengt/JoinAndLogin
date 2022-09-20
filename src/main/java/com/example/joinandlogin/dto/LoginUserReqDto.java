package com.example.joinandlogin.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginUserReqDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;
}
