package com.example.demo.exception;

import com.example.demo.response.IErrorCode;

/**
 * 自定义API异常
 */
public class CustomException extends RuntimeException {
    private IErrorCode errorCode;

    public CustomException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
