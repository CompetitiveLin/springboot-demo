package com.example.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Swagger3API文档的配置
 */
@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API",
                "Some custom description of API.",
                "1.0",
                "Terms of service",
                new Contact("CompetitiveLin", "CompetitiveLin.github.io", "zee_lin@foxmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                //配置网站的基本信息
                .apiInfo(apiInfo())

                // JWT带token_head=bearer时
//                .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER
//                        .name("JWT")
//                        .build()))
//                .securityContexts(Collections.singletonList(SecurityContext.builder()
//                        .securityReferences(Collections.singletonList(SecurityReference.builder()
//                                .scopes(new AuthorizationScope[0])
//                                .reference("JWT")
//                                .build()))

                .securityContexts(Collections.singletonList(SecurityContext.builder()
                        .securityReferences(Collections.singletonList(SecurityReference.builder()
                                .reference("Authorization")
                                .scopes(new AuthorizationScope[0])
                                .build()))
                        .build()))
                .securitySchemes(Collections.singletonList(new ApiKey("Authorization", "Authorization", "header")))
                .select()
                //指定接口的位置
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .build()
                ;
    }


    /**
     * 解决 this.condition = null 空指针报错问题
     * @return
     */
    @Bean
    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {

        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
                List<T> copy = mappings.stream()
                        .filter(mapping -> mapping.getPatternParser() == null)
                        .collect(Collectors.toList());
                mappings.clear();
                mappings.addAll(copy);
            }

            @SuppressWarnings("unchecked")
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    field.setAccessible(true);
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }
}
