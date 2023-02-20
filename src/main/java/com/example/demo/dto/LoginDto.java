package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Schema
public class LoginDto {

    @Schema(name = "用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    @Schema(name = "密码")
    @NotNull(message = "密码不能为空")
    private String password;

    @Schema(name = "uuid")
    @NotNull(message = "uuid不能为空")
    private String uuid;

    @Schema(name = "验证码")
    @NotNull(message = "验证码不能为空")
    private String captcha;
}
