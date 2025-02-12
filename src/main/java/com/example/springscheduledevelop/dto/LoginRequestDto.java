package com.example.springscheduledevelop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestDto {
    // 사용자가 입력한 이메일
    @NotBlank(message = "이메일을 입력해야 합니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private final String email;

    // 사용자가 입력한 비밀번호
    @NotNull(message = "비밀번호를 입력해야 합니다.")
    private final String password;
}
