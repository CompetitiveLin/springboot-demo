package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Schema
public class UpdatePasswordDto {

    @NotBlank(message = "旧密码不能为空")
    @Schema(name = "旧密码")
    private String oldPassword;

    @NotBlank(message = "新密码不能为空")
    @Schema(name = "新密码")
    @Size(min = 6, max = 12, message = "密码长度为6至12位")
    private String newPassword;
}
