package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mbg.model.SysLog;

import java.util.Date;

public interface SysLogService extends IService<SysLog> {
    void insert(String method, long duration, String params, String ip, Date createTime);
}
