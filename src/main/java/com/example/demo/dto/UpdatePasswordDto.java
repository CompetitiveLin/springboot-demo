package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Schema
public class UpdatePasswordDto {

    @NotBlank(message = "用户名不能为空")
    @Schema(name = "用户名", required = true)
    private String username;

    @NotBlank(message = "旧密码不能为空")
    @Schema(name = "旧密码", required = true)
    private String oldPassword;

    @NotBlank(message = "新密码不能为空")
    @Schema(name = "新密码", required = true)
    private String newPassword;
}
