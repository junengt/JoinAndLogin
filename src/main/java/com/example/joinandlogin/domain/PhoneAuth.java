package com.example.joinandlogin.domain;

import com.example.joinandlogin.domain.common.BaseEntity;
import com.example.joinandlogin.dto.JoinPhoneAuthReqDto;
import com.example.joinandlogin.util.code.AuthTypeCode;
import com.example.joinandlogin.util.code.TelecomCode;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "phone_auth")
@Getter
public class PhoneAuth extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_auth_id")
    private Long phoneAuthId;

    @Column(name = "phone_auth_telecom_code")
    @Enumerated(EnumType.STRING)
    private TelecomCode telecomCode;

    @Column(name = "phone_auth_enc_phone_number")
    private String encryptedPhoneNumber;

    @Column(name = "phone_auth_authentication")
    private String authentication;

    @Column(name = "phone_auth_type_code")
    @Enumerated(EnumType.STRING)
    private AuthTypeCode authTypeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //회원 가입 휴대전화 인증 정보 생성자
    public PhoneAuth(JoinPhoneAuthReqDto joinPhoneAuthReqDto, String encryptedPhoneNumber, String authentication,
                     AuthTypeCode authTypeCode) {
        this.telecomCode = joinPhoneAuthReqDto.getTelecomCode();
        this.encryptedPhoneNumber = encryptedPhoneNumber;
        this.authentication = authentication;
        this.authTypeCode = authTypeCode;
    }

}
