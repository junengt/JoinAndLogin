package com.example.joinandlogin.domain;

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
    private String telecomCode;

    @Column(name = "phoneAuth_authentication")
    private String authentication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
