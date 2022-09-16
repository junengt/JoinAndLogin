package com.example.joinandlogin.service;

import com.example.joinandlogin.domain.User;
import com.example.joinandlogin.dto.JoinUserReqDto;
import com.example.joinandlogin.dto.LoginUserReqDto;
import com.example.joinandlogin.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    @Column
    public void joinSuccess() throws Exception {
        JoinUserReqDto joinUserReqDto = new JoinUserReqDto();
        joinUserReqDto.setLoginId("test001");
        joinUserReqDto.setEmail("test@test.com");
        joinUserReqDto.setName("테스트");
        joinUserReqDto.setNickname("테스트닉네임");
        joinUserReqDto.setPassword("testPassword");
        joinUserReqDto.setPhoneNumber("01012345678");

        Long joinUser = userService.joinUser(joinUserReqDto);
        Optional<User> userOptional = userRepository.findById(joinUser);
        User user = userOptional.get();

        assertThat(joinUser).isEqualTo(user.getId());
    }

    @Test
    @Commit
    public void loginSuccess() throws Exception {
        JoinUserReqDto joinUserReqDto = new JoinUserReqDto();
        joinUserReqDto.setLoginId("test001");
        joinUserReqDto.setEmail("test@test.com");
        joinUserReqDto.setName("테스트");
        joinUserReqDto.setNickname("테스트닉네임");
        joinUserReqDto.setPassword("testPassword");
        joinUserReqDto.setPhoneNumber("01012345678");

        LoginUserReqDto loginUserReqDto = new LoginUserReqDto();
        loginUserReqDto.setLoginId("test001");
        loginUserReqDto.setPassword("testPassword");

        Long joinUserId = userService.joinUser(joinUserReqDto);
        Long loginUserId = userService.login(loginUserReqDto);

        assertThat(loginUserId).isEqualTo(joinUserId);
        //콘솔
        User joinUser = userRepository.findById(joinUserId).get();
        User loginUser = userRepository.findById(loginUserId).get();

        System.out.println("joinUser.getEncodedEmail() = " + joinUser.getEncodedEmail());
        System.out.println("joinUser.getEncodedPassword() = " + joinUser.getEncodedPassword());
        System.out.println("joinUser.getEncodedPhoneNumber() = " + joinUser.getEncodedPhoneNumber());

        System.out.println("loginUser.getEncodedEmail() = " + loginUser.getEncodedEmail());
        System.out.println("loginUser.getEncodedPassword() = " + loginUser.getEncodedPassword());
        System.out.println("loginUser.getEncodedPhoneNumber() = " + loginUser.getEncodedPhoneNumber());
    }

}