package com.example.demo.config;

import com.example.demo.component.MyCustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registerMyFilter(){
        FilterRegistrationBean<MyCustomFilter> bean = new FilterRegistrationBean<>();
        bean.setOrder(1);                   // highest priority
        bean.setFilter(new MyCustomFilter());
        bean.addUrlPatterns("/getCaptcha");
        return bean;
    }

}
