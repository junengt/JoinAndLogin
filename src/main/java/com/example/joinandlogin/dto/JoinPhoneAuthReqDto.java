package com.example.joinandlogin.dto;

import com.example.joinandlogin.domain.TelecomCode;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class JoinPhoneAuthReqDto {

    @NotBlank
    private TelecomCode telecomCode;

    @NotBlank
    private String phoneNumber;

}
