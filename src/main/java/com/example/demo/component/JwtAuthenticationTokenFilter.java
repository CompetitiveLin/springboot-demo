package com.example.demo.component;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.demo.dto.UserInfoDetails;
import com.example.demo.config.JwtConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwttokenfilter
 * @author yueranzs
 * @date 2021/12/4 10:14
 */
@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {    // 每次请求都会经过这个filter


    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, ServletException, IOException {
        String authToken = request.getHeader(jwtConfig.getTokenHeader());
        if (ObjectUtil.isNotNull(authToken)) {
            String userName = jwtUtil.getUserNameToken(authToken);
            //当userName不为空且没经过认证时进行校验token是否为有效token
            if (ObjectUtil.isNotNull(userName) && ObjectUtil.isNull(SecurityContextHolder.getContext().getAuthentication())) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                UserInfoDetails user = (UserInfoDetails) userDetails;
                //检验token，新增下面的if判断
                if (StrUtil.equals(userName,user.getUsername()) && jwtUtil.verifyToken(authToken)) {
                    /**
                     * UsernamePasswordAuthenticationToken继承AbstractAuthenticationToken实现Authentication
                     * 所以当在页面中输入用户名和密码之后首先会进入到UsernamePasswordAuthenticationToken验证(Authentication)，
                     * 然后生成的Authentication会被交由AuthenticationManager来进行管理
                     * 而AuthenticationManager管理一系列的AuthenticationProvider，
                     * 而每一个Provider都会通UserDetailsService和UserDetail来返回一个
                     * 以UsernamePasswordAuthenticationToken实现的带用户名和密码以及权限的Authentication
                     */
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(ObjectUtil.isNotNull(auth)){
            log.info(auth.getDetails().toString());
        }
        filterChain.doFilter(request,response);
    }
}