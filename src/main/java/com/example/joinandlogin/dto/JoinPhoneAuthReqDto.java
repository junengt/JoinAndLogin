package com.example.joinandlogin.dto;

import com.example.joinandlogin.util.code.AuthTypeCode;
import com.example.joinandlogin.util.code.TelecomCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class JoinPhoneAuthReqDto {

    @NotBlank
    private TelecomCode telecomCode;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private AuthTypeCode authTypeCode = AuthTypeCode.JOIN;

}
