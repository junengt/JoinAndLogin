package com.example.joinandlogin.controller;

import com.example.joinandlogin.dto.JoinUserReqDto;
import com.example.joinandlogin.dto.LoginUserReqDto;
import com.example.joinandlogin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user")
    public Result joinUser(@RequestBody JoinUserReqDto joinUserReqDto) throws Exception {
        return new Result(userService.joinUser(joinUserReqDto));
    }

    //로그인
    @GetMapping("/user/login")
    public Result login(@RequestBody LoginUserReqDto loginUserReqDto) {
        return new Result(userService.login(loginUserReqDto));
    }


    @AllArgsConstructor
    @Data
    static class Result<T> {
        private T data;
    }
}
