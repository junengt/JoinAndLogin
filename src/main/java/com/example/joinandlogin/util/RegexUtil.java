package com.example.joinandlogin.util;

import java.util.regex.Pattern;

public class RegexUtil {

    private static final String LOGIN_ID_PATTERN = "^[a-zA-Z0-9]{6,12}$"; // 로그인 아이디 패턴. 정규표현식
    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9]{6,12}$";
    private static final String PHONE_NUMBER_PATTERN = "^01([0-9])([0-9]{3,4})([0-9]{4})$";

    /**
     * 로그인 아이디 패턴 확인
     *
     * @param str 정합성을 확인할 문자열
     * @return 정합성 확인 여부
     */
    public static boolean checkLoginPattern(String loginId){
        return Pattern.matches(LOGIN_ID_PATTERN, loginId);
    }

    /**
     * 비밀번호 패턴 확인
     * @param password
     * @return 정합성 확인 여부
     */
    public static boolean checkPasswordPattern(String password) {
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    /**
     * 휴대전화 번호 패턴 확인
     * @param phoneNumber
     * @return 정합성 확인 여부
     */
    public static boolean checkPhoneNumberPattern(String phoneNumber) {
        return Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber);
    }


}
