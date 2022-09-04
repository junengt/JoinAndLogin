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

    @Column(name = "user_eamil")
    private String email;

    @Column(name = "user_nickname")
    private String nickname;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_phone_number")
    private String phoneNumber;

    public User(JoinUserReqDto joinUserReqDto, String encodedPassword) {
        this.email = joinUserReqDto.getEmail();
        this.nickname = joinUserReqDto.getNickname();
        this.password = encodedPassword;
        this.name = joinUserReqDto.getName();
        this.phoneNumber = joinUserReqDto.getPhoneNumber();
    }
}
