package com.example.joinandlogin.domain;

import com.example.joinandlogin.dto.JoinPhoneAuthReqDto;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "phoneAuth")
@Getter
public class PhoneAuth {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phoneAuth_id")
    private Long id;

    @Column(name = "phoneAuth_telecom_code")
    @Enumerated(EnumType.STRING)
    private TelecomCode telecomCode;

    @Column(name = "phoneAuth_enc_phone_number")
    private String encodedPhoneNumber;

    @Column(name = "phoneAuth_authentication")
    private String authentication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //회원 가입 휴대전화 인증 정보 생성자
    public PhoneAuth(JoinPhoneAuthReqDto joinPhoneAuthReqDto, String encodedPhoneNumber, String authentication) {
        this.telecomCode = joinPhoneAuthReqDto.getTelecomCode();
        this.encodedPhoneNumber = encodedPhoneNumber;
        this.authentication = authentication;
    }

}
