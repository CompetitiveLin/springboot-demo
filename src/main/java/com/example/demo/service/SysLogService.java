package com.example.demo.service;

import java.util.Date;

public interface SysLogService {
    void insert(String method, long duration, String params, String ip, Date createTime);
}
