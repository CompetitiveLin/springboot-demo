package com.example.demo.exception;

import com.example.demo.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = CustomException.class)
    public CommonResult<String> handle(CustomException e) {
        if (e.getErrorCode() != null) {
            log.error(e.getErrorCode().getMessage());
            return CommonResult.failed(e.getErrorCode());
        }
        log.error(e.getMessage());
        return CommonResult.failed(e.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> handleException(Exception e) {
        log.error(e.getMessage());
        return CommonResult.failed(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BindException.class)
    public CommonResult<Map<String, String>> handleValidException(BindException e) {
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult<String> handleValidException(ConstraintViolationException ex) {
        return CommonResult.validateFailed(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";")));
    }
}
