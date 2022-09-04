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
    @Commit
    public void joinSuccess() throws Exception {
        JoinUserReqDto joinUserReqDto = new JoinUserReqDto();
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
    public void loginSuccess() throws Exception {
        JoinUserReqDto joinUserReqDto = new JoinUserReqDto();
        joinUserReqDto.setEmail("test@test.com");
        joinUserReqDto.setName("테스트");
        joinUserReqDto.setNickname("테스트닉네임");
        joinUserReqDto.setPassword("testPassword");
        joinUserReqDto.setPhoneNumber("01012345678");

        LoginUserReqDto loginUserReqDto = new LoginUserReqDto();
        loginUserReqDto.setEmail("test@test.com");
        loginUserReqDto.setPassword("testPassword");

        Long joinUser = userService.joinUser(joinUserReqDto);
        Long loginUser = userService.login(loginUserReqDto);

        assertThat(loginUser).isEqualTo(joinUser);
        //콘솔
        User joinUserPassword = userRepository.findById(joinUser).get();
        User loginUserPassword = userRepository.findById(loginUser).get();

        System.out.println("joinUserPassword.getPassword() = " + joinUserPassword.getPassword());
        System.out.println("loginUserPassword.getPassword() = " + loginUserPassword.getPassword());
    }

}