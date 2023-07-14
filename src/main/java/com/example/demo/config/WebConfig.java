package com.example.demo.config;

import com.example.demo.component.IpUrlLimitInterceptor;
import com.example.demo.component.ParseTokenResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

//    @Bean
//    IpUrlLimitInterceptor getIpUrlLimitInterceptor() {
//        return new IpUrlLimitInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getIpUrlLimitInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }

    @Autowired
    private IpUrlLimitInterceptor ipUrlLimitInterceptor;

    @Autowired
    private ParseTokenResolver parseTokenResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipUrlLimitInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(parseTokenResolver);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

}