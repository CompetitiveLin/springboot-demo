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


    /**
     * BindException 用于表示数据绑定失败的异常。
     * 它通常发生在使用 Spring MVC 时，例如在将请求参数绑定到模型对象时。这种异常通常是由于请求参数不符合预期格式或值范围导致的。
     *
     * @param e bindException
     * @return
     */
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
        return CommonResult.failed(map);
    }


    /**
     * ConstraintViolationException 则是在使用 JSR 303 Bean Validation 时可能抛出的异常。
     * 它表示模型对象上的约束未通过验证。这种异常通常是由于<br 模型对象的属性不符合约束要求 >导致的。
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult<String> handleValidException(ConstraintViolationException ex) {
        return CommonResult.failed(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(";")));
    }
}
