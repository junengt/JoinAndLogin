package com.example.joinandlogin.repository;

import com.example.joinandlogin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //로그인 ID 중복 체크
    boolean existsByLoginId(String loginId);

    //이메일 중복 체크
    boolean existsByEncryptedEmail(String encryptedEmail);

    //닉네임 중복 체크
    boolean existsByNickname(String nickname);

    Optional<User> findByLoginId(String loginId);
}
