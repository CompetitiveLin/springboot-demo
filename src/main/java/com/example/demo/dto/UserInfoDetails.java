package com.example.demo.dto;

import com.example.demo.mbg.model.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
/*
    分配系统角色权限
 */
public class UserInfoDetails implements UserDetails {

    private UserInfo userInfo;

    public UserInfoDetails(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(userInfo.getPermission() == (byte) 0) return Arrays.asList(new SimpleGrantedAuthority("admin"));
        else if (userInfo.getPermission() == (byte) 1) return Arrays.asList(new SimpleGrantedAuthority("teacher"));
        return Arrays.asList(new SimpleGrantedAuthority("parents"));
    }

    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername(){
        return userInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userInfo.getStatus().equals((byte) 1);
    }
}
