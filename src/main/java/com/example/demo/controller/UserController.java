package com.example.demo.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.annotation.Log;
import com.example.demo.annotation.ParseToken;
import com.example.demo.dto.UpdatePasswordDto;
import com.example.demo.exception.Asserts;
import com.example.demo.mbg.mapper.UserInfoMapper;
import com.example.demo.response.CommonResult;
import com.example.demo.util.JwtUtil;
import com.example.demo.dto.LoginDto;
import com.example.demo.mbg.model.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserLoginLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.constant.AuthorizationConstant.HEADER_NAME;
import static com.example.demo.constant.AuthorizationConstant.HEADER_PREFIX;

@RestController
@RequestMapping("/user")
@Slf4j
@Validated
@Tag(name = "UserController", description = "管理用户登录等信息")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserLoginLogService userLoginLogService;

    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 查看个人信息
     *
     * @param username
     * @return
     */
    @GetMapping("/information")
    public CommonResult<?> getInformation(@ParseToken String username) {
        return CommonResult.success(userInfoService.getUserByUsername(username));
    }

    /**
     * 参数用表单登录，没有@RequestBody注解。即使方法中的参数是LoginDto类型，但是在实际的参数传输过程中还是以LoginDto里的基本数据类型为准。
     * 例如LoginDto包含username,password,uuid,captcha.前端发送请求时还是按照上述四个参数进行的。LoginDto的作用只是在后端简化方法内的参数。
     * 相反，如果有@RequestBody，那么curl为：
     * curl -X POST -H "Content-type: application/json" -d "{\"username\" : \"John\", \"password\" : \"123\", \"uuid\" : \"1\", \"captcha\" : \"1234\"}" "http://localhost:8080/response/postbody"
     *
     * @param loginDto
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Operation(description = "用户登录")
    public CommonResult<?> login(LoginDto loginDto) {
        String token = HEADER_PREFIX + userLoginLogService.login(loginDto);
        if (token == null)
            return CommonResult.failed("用户名或密码不正确");  // 根据ServiceImpl里的内容，token永远不可能为null，要么已经抛异常，要么返回正确的token
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return CommonResult.success(tokenMap);
    }

    @GetMapping("/login-check")
    @Operation(description = "登录状态检查")
    public CommonResult<?> check(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader(HEADER_NAME);
        if (ObjectUtil.isNull(bearerToken)) Asserts.fail("Token is null");
        String username = JwtUtil.getUserNameBearerToken(bearerToken);
        UserInfo userInfo = userInfoService.getUserByUsername(username);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("username", username);
        hashMap.put("nickname", userInfo.getNickname());
        hashMap.put("role", userInfo.getPermission() == (byte) 0 ? "student" : "teacher");
        return CommonResult.success(hashMap);
    }

    @Log
    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    @Operation(description = "查询所有用户")
    @PreAuthorize("hasAuthority('student')")
    public CommonResult<?> getUser() {
        //日志级别从小到大为 trace < debug < info < warn < error < fatal,由于默认日志级别设置为 INFO，因此 trace 和 debug 级别的日志都看不到。
        log.trace("Trace 日志...");
        log.debug("Debug 日志...");
        log.info("Info 日志...");
        log.warn("Warn 日志...");
        log.error("Error 日志...");
        List<UserInfo> list = userInfoService.getAll();
        return CommonResult.success(list);
    }


    /**
     * 分页查找
     *
     * @param pageNo   页数
     * @param pageSize 每一页的内容数
     * @return
     */
    @GetMapping("/page")
    public CommonResult<?> pageSelect(Integer pageNo, Integer pageSize) {
        Page<UserInfo> page = new Page<>(pageNo, pageSize);
        userInfoMapper.selectPage(page, null);
        return CommonResult.success(page);
    }


    /**
     * 更新密码，当UpdatePasswordDto里的参数不符合要求时，会抛出BindingException的异常，接着会被全局异常捕捉器捕捉，返回异常消息
     *
     * @param username
     * @param updatePasswordDto
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Operation(description = "update password")
    public CommonResult<?> updatePassword(@ParseToken String username,
                                          @RequestBody @Validated UpdatePasswordDto updatePasswordDto) {
        userInfoService.updatePassword(username, updatePasswordDto.getOldPassword(), updatePasswordDto.getNewPassword());
        return CommonResult.success();
    }

    @PostMapping(value = "/reset")
    @Operation(description = "reset password")
    public CommonResult<?> resetPassword(String emailAddress, String captcha, String newPassword) {
        userInfoService.resetPassword(emailAddress, captcha, newPassword);
        return CommonResult.success();
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(description = "Register user")
    public CommonResult<?> register() {
        return CommonResult.success();
    }

    /**
     * 表单登录，将小程序端发送至服务端的code + appid + appsecret 发送至微信服务器，得到session_key 和 openid.
     * 如果使用 (@Responsebody String code) 那么code将是json格式 {"code":"xxx"}
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/wxlogin", method = RequestMethod.POST)
    @Operation(description = "Wechat login")
    public CommonResult<?> wxLogin(String code) {
        String token = userLoginLogService.wxLogin(code);
        if (token == null) return CommonResult.failed("登录失败");
        return CommonResult.success(token);
    }
}
