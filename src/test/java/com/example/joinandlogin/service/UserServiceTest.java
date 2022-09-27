package com.example.joinandlogin.service;

import com.example.joinandlogin.domain.User;
import com.example.joinandlogin.dto.JoinUserReqDto;
import com.example.joinandlogin.dto.LoginUserReqDto;
import com.example.joinandlogin.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void joinSuccess() throws Exception {
        JoinUserReqDto joinUserReqDto = new JoinUserReqDto("test001", "test@test.com", "테스트닉네임",
                "testPassword", "테스트", "01012345678");

        Long joinUser = userService.joinUser(joinUserReqDto);
        Optional<User> userOptional = userRepository.findById(joinUser);
        User user = userOptional.get();

        assertThat(joinUser).isEqualTo(user.getUserId());
    }

    @Test
    @Commit
    public void loginSuccess() throws Exception {
        JoinUserReqDto joinUserReqDto = new JoinUserReqDto("test001", "test@test.com", "테스트닉네임",
                "testPassword", "테스트", "01012345678");

        LoginUserReqDto loginUserReqDto = new LoginUserReqDto("test001", "testPassword");

        Long joinUserId = userService.joinUser(joinUserReqDto);
        Long loginUserId = userService.login(loginUserReqDto);

        assertThat(loginUserId).isEqualTo(joinUserId);
        //콘솔
        User joinUser = userRepository.findById(joinUserId).get();
        User loginUser = userRepository.findById(loginUserId).get();

        System.out.println("joinUser.getEncryptedEmail() = " + joinUser.getEncryptedEmail());
        System.out.println("joinUser.getEncryptedPassword() = " + joinUser.getEncryptedPassword());
        System.out.println("joinUser.getEncryptedPhoneNumber() = " + joinUser.getEncryptedPhoneNumber());

        System.out.println("loginUser.getEncryptedEmail() = " + loginUser.getEncryptedEmail());
        System.out.println("loginUser.getEncryptedPassword() = " + loginUser.getEncryptedPassword());
        System.out.println("loginUser.getEncryptedPhoneNumber() = " + loginUser.getEncryptedPhoneNumber());
    }

}