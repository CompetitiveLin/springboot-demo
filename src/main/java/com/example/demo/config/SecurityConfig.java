package com.example.demo.config;

import com.example.demo.component.*;
import com.example.demo.dto.UserInfoDetails;
import com.example.demo.mbg.model.UserInfo;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
/*
prePostEnabled = true 的作用的是启用Spring Security的  @PreAuthorize 以及 @PostAuthorize 注解。
securedEnabled = true 的作用是启用Spring Security的@Secured 注解。
jsr250Enabled = true 的作用是启用@RoleAllowed 注解
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    private UserInfoService userInfoService;
    @Autowired
    public void getUseInfoService(@Lazy UserInfoService userInfoService){
        this.userInfoService = userInfoService;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserInfo admin = userInfoService.getUserByUsername(username);
                if (admin != null) {
                    return new UserInfoDetails(admin);
                }
                throw new UsernameNotFoundException("用户名或密码错误");
            }
        };
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }



    /**
     * 方法	说明
     * openidLogin()	用于基于 OpenId 的验证
     * headers()	将安全标头添加到响应
     * cors()	配置跨域资源共享（ CORS ）
     * sessionManagement()	允许配置会话管理
     * portMapper()	允许配置一个PortMapper(HttpSecurity#(getSharedObject(class)))，其他提供SecurityConfigurer的对象使用 PortMapper 从 HTTP 重定向到 HTTPS 或者从 HTTPS 重定向到 HTTP。默认情况下，Spring Security使用一个PortMapperImpl映射 HTTP 端口8080到 HTTPS 端口8443，HTTP 端口80到 HTTPS 端口443
     * jee()	配置基于容器的预认证。 在这种情况下，认证由Servlet容器管理
     * x509()	配置基于x509的认证
     * rememberMe	允许配置“记住我”的验证
     * authorizeRequests()	允许基于使用HttpServletRequest限制访问
     * requestCache()	允许配置请求缓存
     * exceptionHandling()	允许配置错误处理
     * securityContext()	在HttpServletRequests之间的SecurityContextHolder上设置SecurityContext的管理。 当使用WebSecurityConfigurerAdapter时，这将自动应用
     * servletApi()	将HttpServletRequest方法与在其上找到的值集成到SecurityContext中。 当使用WebSecurityConfigurerAdapter时，这将自动应用
     * csrf()	添加 CSRF 支持，使用WebSecurityConfigurerAdapter时，默认启用
     * logout()	添加退出登录支持。当使用WebSecurityConfigurerAdapter时，这将自动应用。默认情况是，访问URL”/ logout”，使HTTP Session无效来清除用户，清除已配置的任何#rememberMe()身份验证，清除SecurityContextHolder，然后重定向到”/login?success”
     * anonymous()	允许配置匿名用户的表示方法。 当与WebSecurityConfigurerAdapter结合使用时，这将自动应用。 默认情况下，匿名用户将使用org.springframework.security.authentication.AnonymousAuthenticationToken表示，并包含角色 “ROLE_ANONYMOUS”
     * formLogin()	指定支持基于表单的身份验证。如果未指定FormLoginConfigurer#loginPage(String)，则将生成默认登录页面
     * oauth2Login()	根据外部OAuth 2.0或OpenID Connect 1.0提供程序配置身份验证
     * requiresChannel()	配置通道安全。为了使该配置有用，必须提供至少一个到所需信道的映射
     * httpBasic()	配置 Http Basic 验证
     * addFilterAt()	在指定的Filter类的位置添加过滤器
     */

    /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     */


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
                    .antMatchers(
                            "/js/**", "/css/**","/images/**",
                            "/swagger-resources/**", "/v3/**", "/swagger-ui/**"   //访问swagger所需的静态资源
                            ,"/getCaptcha","/login","/loginCheck", "/register", "/sendEmailCaptcha"
                            )
                    .permitAll()
//                    .antMatchers("/**")   //测试时全部允许访问
//                    .permitAll()
//                    .anyRequest().authenticated()  // 除上面外的所有请求全部需要鉴权认证
                    .and()
                .formLogin()
                    .loginPage("/login.html")
//                    .loginProcessingUrl("/login")   // 前端的action="/login"
                    .permitAll()
                    .and()
                .csrf()
                    .disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        禁止页面缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

}
