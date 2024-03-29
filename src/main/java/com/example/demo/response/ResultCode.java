package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 常用API返回对象
 */
@AllArgsConstructor
@Getter
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),

    FAILED(400, "操作失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    VALIDATE_FAILED(404, "参数检验失败"),
    LOCK_IP(423, "IP已被锁定");



    private long code;
    private String message;
}
