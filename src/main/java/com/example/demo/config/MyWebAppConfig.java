package com.example.demo.config;

import com.example.demo.component.IpUrlLimitInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Slf4j
public class MyWebAppConfig extends WebMvcConfigurerAdapter {

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipUrlLimitInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}