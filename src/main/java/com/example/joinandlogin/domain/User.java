package com.example.joinandlogin.domain;

import com.example.joinandlogin.domain.common.BaseEntity;
import com.example.joinandlogin.dto.JoinUserReqDto;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_login_id")
    private String loginId;

    @Column(name = "user_enc_email")
    private String encryptedEmail;

    @Column(name = "user_nickname")
    private String nickname;

    @Column(name = "user_enc_password")
    private String encryptedPassword;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_enc_phone_number")
    private String encryptedPhoneNumber;

    public User(JoinUserReqDto joinUserReqDto,String encryptedEmail,String encryptedPhoneNumber, String encryptedPassword) {
        this.loginId = joinUserReqDto.getLoginId();
        this.encryptedEmail = encryptedEmail;
        this.nickname = joinUserReqDto.getNickname();
        this.encryptedPassword = encryptedPassword;
        this.name = joinUserReqDto.getName();
        this.encryptedPhoneNumber = encryptedPhoneNumber;
    }

}
