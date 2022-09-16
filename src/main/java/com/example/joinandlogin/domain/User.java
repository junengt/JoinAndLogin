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
    private Long id;

    @Column(name = "user_login_id")
    private String loginId;

    @Column(name = "user_enc_email")
    private String encodedEmail;

    @Column(name = "user_nickname")
    private String nickname;

    @Column(name = "user_enc_password")
    private String encodedPassword;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_enc_phone_number")
    private String encodedPhoneNumber;

    public User(JoinUserReqDto joinUserReqDto,String encodedEmail,String encodedPhoneNumber, String encodedPassword) {
        this.loginId = joinUserReqDto.getLoginId();
        this.encodedEmail = encodedEmail;
        this.nickname = joinUserReqDto.getNickname();
        this.encodedPassword = encodedPassword;
        this.name = joinUserReqDto.getName();
        this.encodedPhoneNumber = encodedPhoneNumber;
    }

}
