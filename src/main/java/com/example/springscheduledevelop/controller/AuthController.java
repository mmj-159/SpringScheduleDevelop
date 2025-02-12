package com.example.springscheduledevelop.controller;

import com.example.springscheduledevelop.dto.LoginRequestDto;
import com.example.springscheduledevelop.entity.User;
import com.example.springscheduledevelop.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session){
        User user = userService.login(loginRequestDto.getEmail(),loginRequestDto.getPassword());

        session.setAttribute("user",user);
        return ResponseEntity.ok("로그인 성공");
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }
}
