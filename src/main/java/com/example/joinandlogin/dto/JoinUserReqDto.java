package com.example.joinandlogin.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class JoinUserReqDto {

    @NotBlank
    private String loginId;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 4, max = 16)
    private String nickname;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;
}
