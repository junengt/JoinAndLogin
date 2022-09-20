package com.example.joinandlogin.dto;

import com.example.joinandlogin.domain.PhoneAuth;
import com.example.joinandlogin.util.code.TelecomCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Data
public class JoinPhoneAuthReqDto {

    @NotBlank
    private TelecomCode telecomCode;

    @NotBlank
    private String phoneNumber;

}
