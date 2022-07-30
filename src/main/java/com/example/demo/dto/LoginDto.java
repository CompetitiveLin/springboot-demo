package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginDto {

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty("uuid")
    @NotNull(message = "uuid不能为空")
    private String uuid;

    @ApiModelProperty("验证码")
    @NotNull(message = "验证码不能为空")
    private String captcha;
}
