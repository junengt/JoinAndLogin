package com.example.joinandlogin.repository;

import com.example.joinandlogin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //이메일 중복 체크
    boolean existsByEncodedEmail(String encodedEmail);

    //닉네임 중복 체크
    boolean existsByNickname(String nickname);

    Optional<User> findByLoginId(String loginId);
}
