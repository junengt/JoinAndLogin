package com.example.joinandlogin.repository;

import com.example.joinandlogin.domain.PhoneAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneAuthRepository extends JpaRepository<PhoneAuth, Long> {
}
