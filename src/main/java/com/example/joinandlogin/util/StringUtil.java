package com.example.joinandlogin.util;

import java.util.UUID;

public class StringUtil {

    //UUID 생성 메소드
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
