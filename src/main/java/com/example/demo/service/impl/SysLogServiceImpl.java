package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mbg.mapper.SysLogMapper;
import com.example.demo.mbg.model.SysLog;
import com.example.demo.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog>
        implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void insert(String method, long duration, String params, String ip, Date createTime) {
        SysLog sysLog = new SysLog();
        sysLog.setMethod(method);
        sysLog.setDuration(duration);
        sysLog.setParams(params);
        sysLog.setIp(ip);
        sysLog.setCreateTime(createTime);
        sysLogMapper.insert(sysLog);
    }
}
