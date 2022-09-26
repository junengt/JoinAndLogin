package com.example.joinandlogin.repository;

import com.example.joinandlogin.domain.PhoneAuth;
import com.example.joinandlogin.util.code.AuthTypeCode;
import com.example.joinandlogin.util.code.TelecomCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneAuthRepository extends JpaRepository<PhoneAuth, Long> {

    Optional<PhoneAuth> findByEncryptedPhoneNumberAndTelecomCodeAndAuthTypeCodeOrderByUpdatedDateDesc(String encryptedPhoneNumber,
                                                                                TelecomCode telecomCode, AuthTypeCode authTypeCode);
}
