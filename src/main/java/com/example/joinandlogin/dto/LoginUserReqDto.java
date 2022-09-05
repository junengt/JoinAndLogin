package com.example.joinandlogin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginUserReqDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;
}
