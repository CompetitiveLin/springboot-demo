package com.example.demo.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.constant.AuthorizationConstant.HEADER_PREFIX;

/**
 * jwt工具类
 * @author yueranzs
 * @date 2021/11/25 15:55
 */
@Slf4j
@Component
public class JwtUtil {

    private static String SECRET;

    private static Long EXPIRATION;

    @Value("${jwt.secret}")         // value无法直接给static变量赋值
    private String SECRET_TEMP;

    @Value("${jwt.expiration}")
    private Long EXPIRATION_TEMP;

    @PostConstruct
    private void init(){
        SECRET = SECRET_TEMP;
        EXPIRATION = EXPIRATION_TEMP;
    }

    /**
     * 生成jwt
     * @param payload 数据主体
     * @return
     */
    public static String create(Map<String,Object> payload){
        //每个jwt都默认生成一个到期时间
        payload.put("expire_time", DateUtil.currentSeconds() + EXPIRATION);
        //生成私钥
        JWTSigner jwtSigner = JWTSignerUtil.hs256(SECRET.getBytes(StandardCharsets.UTF_8));
        //生成token
        return JWTUtil.createToken(payload,jwtSigner);
    }

    /**
     * 解析jwt
     * @param token
     * @return
     */
    public static JSONObject parse(String token){
        JSONObject jsonObject = null;
        try{
            jsonObject = JWTUtil.parseToken(token).getPayload().getClaimsJson();
        }
        catch (Exception e){
            log.error("JWT格式验证失败");
        }
        return jsonObject;
    }

    /**
     * 校验token是否正确
     * @param token
     * @return
     */
    public static boolean verifyToken(String token){
        //先判断是否到期，再判断是否正确
        if (isNotExpiredToken(token)) {
            return JWTUtil.verify(token, SECRET.getBytes(StandardCharsets.UTF_8));
        }
        return false;
    }

    /**
     * 校验token是否过期
     * @param token
     * @return
     */
    public static boolean isNotExpiredToken(String token){
        return DateUtil.currentSeconds() < getExpiredToken(token);
    }

    /**
     * 获取token过期时间
     * @param token
     * @return
     */
    public static long getExpiredToken(String token){
        return parse(token) == null ? null : Long.parseLong(parse(token).get("expire_time").toString());
    }


    /**
     * 获取登录人账号
     * @param bearerToken is like `Bearer XXXXXXXXXX`
     * @return
     */
    public static String getUserNameBearerToken(String bearerToken){
        return getUserNameToken(bearerToken.substring(HEADER_PREFIX.length()));
    }


    /**
     * 获取登录人账号
     * @param token is like `XXXXXXXXXX`
     * @return
     */
    public static String getUserNameToken(String token){
        return parse(token) == null ? null : parse(token).get("username").toString();
    }

    /**
     * 刷新Token，如果30分钟内刷新过，返回原token，否则返回新token
     * @param token
     * @return
     */
    public static String refreshToken(String token){
        if(checkRefreshWithin(token, 30 * 60))  return token;
        Map<String, Object> map = new HashMap<>();
        map.put("username", getUserNameToken(token));
        return create(map);
    }

    /**
     * 检查一定时间内是否刷新过。Time时间内刷新过返回True，否则返回False
     * @param token
     * @param time
     * @return
     */
    public static boolean checkRefreshWithin(String token, long time){
        return time > DateUtil.currentSeconds() + EXPIRATION - getExpiredToken(token);
    }


}