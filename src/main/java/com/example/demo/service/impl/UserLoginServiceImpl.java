package com.example.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mbg.mapper.UserLoginLogMapper;
import com.example.demo.mbg.model.UserLoginLog;
import com.example.demo.service.UserLoginLogService;
import com.example.demo.service.RedisService;
import com.example.demo.util.HttpClientUtil;
import com.example.demo.util.IpUtil;
import com.example.demo.util.JwtUtil;
import com.example.demo.dto.LoginDto;
import com.example.demo.exception.Asserts;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.constant.RedisKeyConstant.captcha.CAPTCHA_UUID;
import static com.example.demo.constant.RedisKeyConstant.token.TOKEN_USERNAME;

@Service
@Slf4j
public class UserLoginServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog>
        implements UserLoginLogService {

    private final static String APPID = "wx9b9baf564eb3bae7";

    private final static String APPSECRET = "a390e4b029567168bd9b86b82046c2e0";

    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${jwt.expiration}")
    private Long JWT_EXPIRATION;

    /**
     * 表单登录。
     * 根据常理，应先校验验证码，其次校验密码。当用户名不存在时，loadUserByUsername方法会抛出异常，因此对整段代码加上try。
     * 当验证码校验或者密码校验出现问题时，都抛出异常，统一交给catch中管理，catch得到异常后进行Asserts.fail，再进行全局异常处理
     *
     * @param loginDto
     * @return
     */
    @Override
    public String login(LoginDto loginDto) {
        try {
            String key = CAPTCHA_UUID + loginDto.getUuid();
            Object redisCode = redisService.get(key);
            if (ObjectUtil.notEqual(redisCode, loginDto.getCaptcha())) {
                throw new Exception("验证码错误");
            }
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
            if (!passwordEncoder.matches(loginDto.getPassword(), userDetails.getPassword())) {
                throw new Exception("密码错误");
            }
            redisService.delete(key);
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
            String token = JwtUtil.create(map);
            // 为方便查看，存入redis中，但其实没必要存到redis中
            String key_token = TOKEN_USERNAME + JwtUtil.getUserNameToken(token);
            redisService.set(key_token, token, JWT_EXPIRATION);

            return token;
        } catch (Exception e) {
            Asserts.fail(e.getMessage());
            return null;
        }
    }

    @Override
    public void insertLog(Long userId, String browser, String platform, String ip, String os) {
//        UserLoginLog userLoinLog = new UserLoginLog();
//        userLoinLog.setUserId(userId);
//        userLoinLog.setBrowserType(browser);
//        userLoinLog.setPlatform(platform);
//        userLoinLog.setIpAddress(ip);
//        userLoinLog.setAddress(IpUtil.getIpPosition(ip));
//        userLoinLog.setOperatingSystem(os);
//        userLoinLog.setLoginTime(new Date());
//        userLoginLogMapper.insertSelective(userLoinLog);
    }

    @Override
    public String wxLogin(String code) {
        Map<String, String> param = new HashMap<>();
        param.put("appid", APPID);
        param.put("secret", APPSECRET);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        String json = HttpClientUtil.doGet("https://api.weixin.qq.com/sns/jscode2session", param);
        JSONObject jsonObject = JSONUtil.parseObj(json);
        if (jsonObject.getStr("errmsg") != null) return null;
        Map<String, Object> map = new HashMap<>();
        map.put("openid", jsonObject.getStr("openid"));
        String token = JwtUtil.create(map);
        redisService.set("wx:token:" + jsonObject.getStr("openid"), token, JWT_EXPIRATION);
        return token;
    }
}
