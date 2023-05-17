package com.example.demo.exception;

import com.example.demo.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus
    @ExceptionHandler(value = ApiException.class)
    public CommonResult handle(ApiException e) {
        if (e.getErrorCode() != null) {
            log.error(e.getErrorCode().getMessage());
            return CommonResult.failed(e.getErrorCode());
        }
        log.error(e.getMessage());
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus
    @ExceptionHandler(value = BindException.class)
    public CommonResult handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                map.put("message", fieldError.getDefaultMessage());
                map.put("field", fieldError.getField());
            }
        }
        return CommonResult.validateFailed(map);
    }


    @ResponseBody
    @ResponseStatus
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult handleValidException(ConstraintViolationException ex) {
        return CommonResult.validateFailed(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";")));

    }
}
