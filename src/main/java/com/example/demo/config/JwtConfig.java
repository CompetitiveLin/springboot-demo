package com.example.demo.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * jwt配置类
 * @author yueranzs
 * @date 2021/12/4 9:57
 */
@Data
@ToString
@Configuration
//与配置文件中的数据关联起来(这个注解会默认自动匹配jwt开头的配置)
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    /*request Headers : Authorization*/     // @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    /*Base64对该令牌进行编码*/
    private String secret;

    /*令牌过期时间 此处单位秒 */
    private Long expiration;

}
