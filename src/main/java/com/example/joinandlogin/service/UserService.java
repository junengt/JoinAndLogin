package com.example.joinandlogin.service;

import com.example.joinandlogin.domain.User;
import com.example.joinandlogin.dto.JoinUserReqDto;
import com.example.joinandlogin.dto.LoginUserReqDto;
import com.example.joinandlogin.exception.LoginCheckException;
import com.example.joinandlogin.repository.UserRepository;
import com.example.joinandlogin.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //회원 가입
    @Transactional
    public Long joinUser(JoinUserReqDto joinUserReqDto) throws Exception {
        String encodedEmail = EncryptUtil.encryptAES256(joinUserReqDto.getEmail());
        String encodedPassword = passwordEncoder.encode(joinUserReqDto.getPassword());
        String encodedPhoneNumber = EncryptUtil.encryptAES256(joinUserReqDto.getPhoneNumber());
        return userRepository.save(new User(joinUserReqDto,encodedEmail,encodedPhoneNumber, encodedPassword)).getId();
    }

    //로그인
    public Long login(LoginUserReqDto loginUserReqDto) {
        Optional<User> userOptional = userRepository.findByLoginId(loginUserReqDto.getLoginId());
        if (userOptional.isEmpty()) {
            throw new LoginCheckException("로그인에 실패했습니다.");
        }

        User user = userOptional.get();
        if(!passwordEncoder.matches(loginUserReqDto.getPassword(), user.getEncodedPassword())) {
            throw new LoginCheckException("로그인에 실패했습니다.");
        }
        return user.getId();
    }

}
