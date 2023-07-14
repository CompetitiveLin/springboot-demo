package com.example.demo.config.resolver;

import com.example.demo.annotation.ParseToken;
import com.example.demo.exception.ApiException;
import com.example.demo.util.JwtUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class ParseTokenResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //如果有ParseToken则使用该解析器
        return methodParameter.hasParameterAnnotation(ParseToken.class);
    }

    @Override
    public Object resolveArgument(@NotNull MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String[] tokens = nativeWebRequest.getHeaderValues("Authorization");
        if (tokens != null && tokens.length > 0) {
            String token = tokens[0];
            return JwtUtil.getUserNameBearerToken(token);
        }
        throw new ApiException("Token error");
    }
}