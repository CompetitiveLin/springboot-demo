package com.example.demo.mbg.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;

public class UserLoginLog implements Serializable {
    @Schema(name = "用户登录记录id")
    private Long id;

    @Schema(name = "用户id")
    private Long userId;

    @Schema(name = "ip地址")
    private String ipAddress;

    @Schema(name = "ip地址所对应的地区")
    private String address;

    @Schema(name = "登录时间")
    private Date loginTime;

    @Schema(name = "浏览器类型")
    private String browserType;

    @Schema(name = "操作系统")
    private String operatingSystem;

    @Schema(name = "登录平台")
    private String platform;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append(", address=").append(address);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", browserType=").append(browserType);
        sb.append(", operatingSystem=").append(operatingSystem);
        sb.append(", platform=").append(platform);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}