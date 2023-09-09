package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc配置
 *
 * @url: http://localhost:8080/swagger-ui/index.html
 * @Author CommpetitiveLin
 * @Date 2023-02-20 12:04:22
 */
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My REST API")
                        .description("description")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("CompetitiveLin")
                                .email("zee_lin@foxmail.com")
                                .url("CompetitiveLin.github.io"))
                        .license(new License().name("MIT")))
                .externalDocs(new ExternalDocumentation().url("https://springdoc.org/"))
                .addSecurityItem(new SecurityRequirement().addList("Authorization"))
                .components(new Components().addSecuritySchemes("Authorization", new SecurityScheme()
                        .name("Authorization")
                        .scheme("bearer")
                        .type(SecurityScheme.Type.HTTP)
                        .in(SecurityScheme.In.HEADER)));
    }
}
