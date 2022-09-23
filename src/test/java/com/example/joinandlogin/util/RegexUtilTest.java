package com.example.joinandlogin.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RegexUtilTest {

    @Test
    public void checkPhoneNumberSuccessTest() throws Exception {
        //given: 이런 게 주어졌을 때
        String phoneNumber = "01012345678";

        //when: 이렇게 하면
        boolean check = RegexUtil.checkPhoneNumberPattern(phoneNumber);

        //then: 이렇게 된다
        assertThat(check).isEqualTo(true);
    }

    @Test
    public void checkPhoneNumberFailTest() throws Exception {
        //given: 이런 게 주어졌을 때
        String phoneNumber = "010123456789";

        //when: 이렇게 하면
        boolean check = RegexUtil.checkPhoneNumberPattern(phoneNumber);

        //then: 이렇게 된다
        assertThat(check).isEqualTo(true);
    }

}