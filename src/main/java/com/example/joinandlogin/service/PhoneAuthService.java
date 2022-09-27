package com.example.joinandlogin.service;

import com.example.joinandlogin.domain.PhoneAuth;
import com.example.joinandlogin.dto.ConfirmPhoneAuthReqDto;
import com.example.joinandlogin.dto.ConfirmPhoneAuthResDto;
import com.example.joinandlogin.dto.JoinPhoneAuthReqDto;
import com.example.joinandlogin.exception.PhoneNumberCheckException;
import com.example.joinandlogin.repository.PhoneAuthRepository;
import com.example.joinandlogin.util.EncryptUtil;
import com.example.joinandlogin.util.RegexUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PhoneAuthService {

    private final PhoneAuthRepository phoneAuthRepository;

    // 별도의 DTO Validation 함수

    //회원가입 인증 정보 저장
    public void joinPhoneAuth(JoinPhoneAuthReqDto reqDto) throws Exception {

        //휴대전화 번호 패턴 체크
        if (!RegexUtil.checkPhoneNumberPattern(reqDto.getPhoneNumber())) {
            throw new PhoneNumberCheckException("올바른 휴대전화 번호를 입력하세요.");
        }

        //이미 저장된 인증 정보가 있다면 가져오기
        Optional<PhoneAuth> phoneAuth = phoneAuthRepository.findByEncryptedPhoneNumberAndTelecomCodeAndAuthTypeCodeOrderByUpdatedDateDesc(
                EncryptUtil.encryptAES256(reqDto.getPhoneNumber()), reqDto.getTelecomCode(), reqDto.getAuthTypeCode());

        if (phoneAuth.isPresent()) {
            return;
        }

        //인증 정보 저장
        String authentication = reqDto.getPhoneNumber().substring(reqDto.getPhoneNumber().length() - 6);
        String encryptedPhoneNumber = EncryptUtil.encryptAES256(reqDto.getPhoneNumber());
        phoneAuthRepository.save(new PhoneAuth(reqDto, encryptedPhoneNumber, authentication, reqDto.getAuthTypeCode()));
    }

}
