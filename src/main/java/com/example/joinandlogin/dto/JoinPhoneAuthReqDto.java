package com.example.joinandlogin.dto;

import com.example.joinandlogin.util.code.TelecomCode;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Data
public class JoinPhoneAuthReqDto {

    @NotBlank
    private TelecomCode telecomCode;

    @NotBlank
    private String phoneNumber;

}
