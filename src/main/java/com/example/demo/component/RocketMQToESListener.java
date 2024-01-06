package com.example.demo.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.Idempotency;
import com.example.demo.mbg.model.SysLog;
import com.example.demo.repository.CanalToElasticsearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
@Slf4j
@RocketMQMessageListener(topic = "CanalTopic", consumerGroup = "springboot_consumer_group")
@RequiredArgsConstructor
public class RocketMQToESListener implements RocketMQListener<MessageExt> {


    private final CanalToElasticsearchRepository canalToElasticsearchRepository;

    @Override
    @Idempotency(period = 100)
    public void onMessage(MessageExt s) {
        String message = new String(s.getBody(), StandardCharsets.UTF_8);
        log.info(message);
        JSONObject json = JSON.parseObject(message);
        String data = json.getString("data");
        String type = json.getString("type");
        List<SysLog> list = JSON.parseArray(data, SysLog.class);
        for (SysLog syslog : list) {
            if ("INSERT".equals(type) || "UPDATE".equals(type)) {
                canalToElasticsearchRepository.save(syslog);
            } else if ("DELETE".equals(type)) {
                canalToElasticsearchRepository.deleteById(syslog.getId().toString());
            }
        }
    }
}
