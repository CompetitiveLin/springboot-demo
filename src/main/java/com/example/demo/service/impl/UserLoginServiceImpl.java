package com.example.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.component.JwtUtil;
import com.example.demo.component.RedisUtil;
import com.example.demo.config.JwtConfig;
import com.example.demo.dto.LoginDto;
import com.example.demo.exception.Asserts;
import com.example.demo.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${jwt.expiration}")
    private Long JWT_EXPIRATION;

    /**
     * 表单登录。
     * 根据常理，应先校验验证码，其次校验密码。当用户名不存在时，loadUserByUsername方法会抛出异常，因此对整段代码加上try。
     * 当验证码校验或者密码校验出现问题时，都抛出异常，统一交给catch中管理，catch得到异常后进行Asserts.fail，再进行全局异常处理
     * @param loginDto
     * @return
     */
    @Override
    public String login(LoginDto loginDto) {
        try{
            Object redisCode = redisUtil.stringGet("captcha:" + loginDto.getUuid());
            if(ObjectUtil.notEqual(redisCode, loginDto.getCaptcha())){
                throw new Exception("验证码错误");
            }
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
            if (!passwordEncoder.matches(loginDto.getPassword(), userDetails.getPassword())) {
                throw new Exception("密码错误");
            }
            redisUtil.delete("captcha:" + loginDto.getUuid());
            //获得HttpServletRequest对象
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 获取ip地址，后续可存入数据库记录登录数据
            log.info("ip:" + request.getRemoteAddr());
            Map<String, Object> map = new HashMap<>();
            map.put("username", loginDto.getUsername());
            String token = jwtUtil.create(map);
            redisUtil.stringSet("token:" + jwtUtil.getUserNameToken(token), token, JWT_EXPIRATION);
            return token;
        }
        catch(Exception e){
            Asserts.fail(e.getMessage());
            return null;
        }
    }
}