package com.example.demo.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 常用API返回对象
 * Created by macro on 2019/4/19.
 */
@AllArgsConstructor
@Getter
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private long code;
    private String message;
}
