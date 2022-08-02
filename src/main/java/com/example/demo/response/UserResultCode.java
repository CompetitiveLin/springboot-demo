package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserResultCode implements IErrorCode {

    /*用户盐*/
    USER_SALT(4001,"user_salt"),
    /*用户状态*/
    USER_STATUS(1,"用户有效"),
    USER_NOT_STATUS(0,"用户锁定"),

    /* 用户错误 */
    USER_NOT_PROOF(2001, "暂无凭证或是认证失败"),
    USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
    USER_CREDENTIALS_ERROR(2003, "密码错误"),
    USER_CREDENTIALS_EXPIRED(2004, "密码过期"),
    USER_ACCOUNT_DISABLE(2005, "账号被禁用"),
    USER_ACCOUNT_LOCKED(2006, "账号被锁定"),
    USER_ACCOUNT_NOT_EXIST(2007, "账号不存在"),
    USER_ACCOUNT_ALREADY_EXIST(2008, "账号已存在"),
    USER_ACCOUNT_USE_BY_OTHERS(2009, "账号下线"),
    USER_NOT_HEADPORTRAIT(2010, "暂无用户头像"),
    USER_NOT_ID(2011,"请输入用户编号"),
    USER_NOT_NAME(2012,"请输入用户账号"),
    USER_NOT_PASSWORD(2013,"请输入用户密码"),
    USER_NOT_RANDOMCODE(2013,"请输入验证码key"),
    USER_NOT_CODE(2014,"请输入验证码value"),
    USER_INSUFFICIENT_PERMISSIONS(2015,"权限不足"),

    /* 用户退出 */
    USER_LOGOUT_SUCCESS(2050,"用户退出成功"),
    USER_LOGOUT_ERROR(2051,"用户退出失败"),
    /* 用户登录 */
    USER_LOGIN_SUCCESS(2052,"用户登录成功"),
    USER_LOGIN_ERROR(2053,"用户登录失败"),
    USER_LOGIN_ERROR_NO(2054,"用户名或者密码输入错误"),

    /*redis*/
    REDIS_CODE(2150,"验证码错误"),
    ;

    private long code;
    private String message;

}
