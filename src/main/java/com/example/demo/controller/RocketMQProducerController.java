package com.example.demo.controller;

import com.example.demo.constant.RocketMQConstant;
import com.example.demo.response.CommonResult;
import com.example.demo.util.MessagesSplitter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class RocketMQProducerController {
    /*
    RocketMQ的消息发送方式主要含syncSend()同步发送、asyncSend()异步发送、sendOneWay()三种方式，sendOneWay()也是异步发送
    区别在于不需等待Broker返回确认，所以可能会存在信息丢失的状况，但吞吐量更高，具体需根据业务情况选用。
    性能：sendOneWay > asyncSend > syncSend，RocketMQTemplate的send()方法默认是同步(syncSend)的
    // messageDelayLevel= 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h, start with 1.
     */
    private final RocketMQTemplate rocketMQTemplate;

    @PostMapping("/sync-ordinary")
    public CommonResult<?> sendMessageSynchronously() {
        Message<String> message = MessageBuilder.withPayload("send ordinary message synchronously").build();
        log.info("生产者发送消息: {}", message);
        SendResult sendResult = this.rocketMQTemplate.syncSend((RocketMQConstant.TOPIC_PREFIX + "starter:sync"), message);
        log.info("消息发送状态: {}", sendResult);
        return CommonResult.success(sendResult);
    }

    @PostMapping("/async-ordinary")
    public CommonResult<?> sendMessageAsynchronously() {
        Message<String> message = MessageBuilder.withPayload("send ordinary message asynchronously").build();
        this.rocketMQTemplate.asyncSend((RocketMQConstant.TOPIC_PREFIX + "starter:async"), message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("消息发送状态: {}", sendResult);
            }

            @Override
            public void onException(Throwable e) {
                log.info("消息发送失败，原因: ", e);
            }
        });
        log.info("生产者发送消息: {}", message);
        return CommonResult.success(message);
    }

    @PostMapping("/one-way")
    public CommonResult<?> sendOneWayMessage() {
        Message<String> message = MessageBuilder.withPayload("send one-way message").build();
        log.info("生产者发送消息: {}", message);
        rocketMQTemplate.sendOneWay((RocketMQConstant.TOPIC_PREFIX + "starter:one-way"), message);
        return CommonResult.success(message);
    }

    @PostMapping("/clustering-consume")
    public CommonResult<?> clusteringConsume() {
        for (int i = 0; i < 20; i++) {
            String messageBody = "测试集群消费模式第" + (i + 1) + "条消息";
            Message<String> message = MessageBuilder.withPayload(messageBody).build();
            log.info("生产者发送消息: {}", message);
            rocketMQTemplate.syncSend((RocketMQConstant.TOPIC_PREFIX + "starter-clustering"), message);
        }
        return CommonResult.success();
    }

    @PostMapping("/broadcast-consume")
    public CommonResult<?> broadcastConsume() {
        for (int i = 0; i < 20; i++) {
            String messageBody = "测试广播消费模式第" + (i + 1) + "条消息";
            Message<String> message = MessageBuilder.withPayload(messageBody).build();
            log.info("生产者发送消息: {}", message);
            this.rocketMQTemplate.syncSend((RocketMQConstant.TOPIC_PREFIX + "starter-broadcast"), message);
        }
        return CommonResult.success();
    }

    @PostMapping("/global-order")
    public CommonResult<?> sendGlobalOrderMessage() {
        for (int i = 0; i < 10; i++) {
            String messageBody = "测试全局有序消息第" + (i + 1) + "条消息";
            Message<String> message = MessageBuilder.withPayload(messageBody).build();
            log.info("生产者发送消息: {}", message);
            // 传入hashKey来指定具体的一个队列
            this.rocketMQTemplate.syncSendOrderly((RocketMQConstant.TOPIC_PREFIX + "starter-global-order"), message, "111");
        }
        return CommonResult.success();
    }

    @PostMapping("/partitioned-order")
    public CommonResult<?> sendPartitionedOrderMessage() {
        Message<String> message1 = MessageBuilder.withPayload("订单1创建").build();
        log.info("生产者发送消息: {}", message1);
        this.rocketMQTemplate.syncSendOrderly((RocketMQConstant.TOPIC_PREFIX + "starter-partitioned-order"), message1, "111");
        Message<String> message2 = MessageBuilder.withPayload("订单2创建").build();
        log.info("生产者发送消息: {}", message2);
        this.rocketMQTemplate.syncSendOrderly((RocketMQConstant.TOPIC_PREFIX + "starter-partitioned-order"), message2, "222");
        Message<String> message3 = MessageBuilder.withPayload("订单1支付").build();
        log.info("生产者发送消息: {}", message3);
        this.rocketMQTemplate.syncSendOrderly((RocketMQConstant.TOPIC_PREFIX + "starter-partitioned-order"), message3, "111");
        Message<String> message4 = MessageBuilder.withPayload("订单2支付").build();
        log.info("生产者发送消息: {}", message4);
        this.rocketMQTemplate.syncSendOrderly((RocketMQConstant.TOPIC_PREFIX + "starter-partitioned-order"), message4, "222");
        Message<String> message5 = MessageBuilder.withPayload("订单1发货").build();
        log.info("生产者发送消息: {}", message5);
        this.rocketMQTemplate.syncSendOrderly((RocketMQConstant.TOPIC_PREFIX + "starter-partitioned-order"), message5, "111");
        Message<String> message6 = MessageBuilder.withPayload("订单2发货").build();
        log.info("生产者发送消息: {}", message6);
        this.rocketMQTemplate.syncSendOrderly((RocketMQConstant.TOPIC_PREFIX + "starter-partitioned-order"), message6, "222");
        return CommonResult.success();
    }

    @PostMapping("/delay")
    public CommonResult<?> sendDelayMessage() {
        Message<String> message = MessageBuilder.withPayload("send delay message").build();
        log.info("生产者发送消息: {}", message);
        SendResult sendResult = this.rocketMQTemplate.syncSend((RocketMQConstant.TOPIC_PREFIX + "starter:delay"), message, 3000, 2);
        log.info("消息发送状态: {}", sendResult);
        return CommonResult.success();
    }

    @PostMapping("/batch")
    public CommonResult<?> sendMessageInBatch() {
        List<Message<String>> messages = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String messageBody = "批量发送消息第" + i + "条";
            Message<String> message = MessageBuilder.withPayload(messageBody).build();
            messages.add(message);
            log.info("生产者发送消息: {}", message);
        }

        // 可能这个消息集合超出限制，需要将其分裂成若干个满足要求的小消息
        MessagesSplitter messagesSplitter = new MessagesSplitter(messages);
        while (messagesSplitter.hasNext()) {
            List<Message<String>> subMessageList = messagesSplitter.next();
            SendResult sendResult = this.rocketMQTemplate.syncSend((RocketMQConstant.TOPIC_PREFIX + "starter:batch"), subMessageList);
            log.info("消息发送状态: {}", sendResult);

        }
        return CommonResult.success();
    }

    @PostMapping("/tag-filter-message")
    public CommonResult<?> tagFilterMessage() {
        // 消费者方设置如下
        // 消费者只接受tag为phone或clothes的消息
        Message<String> message1 = MessageBuilder.withPayload("订单1").build();
        log.info("生产者发送消息: {}", message1);
        this.rocketMQTemplate.sendOneWay((RocketMQConstant.TOPIC_PREFIX + "starter-tag-filter:phone"), message1);
        Message<String> message2 = MessageBuilder.withPayload("订单2").build();
        log.info("生产者发送消息: {}", message2);
        this.rocketMQTemplate.sendOneWay((RocketMQConstant.TOPIC_PREFIX + "starter-tag-filter:shoes"), message2);
        Message<String> message3 = MessageBuilder.withPayload("订单3").build();
        log.info("生产者发送消息: {}", message3);
        this.rocketMQTemplate.sendOneWay((RocketMQConstant.TOPIC_PREFIX + "starter-tag-filter:clothes"), message3);
        return CommonResult.success();
    }

    @PostMapping("/sql-filter-message")
    public CommonResult<?> sqlFilterMessage() {
        // 消费者方设置如下
        // 消费者只接受tag为phone而且price在[400-500]区间的消息
        Message<String> message1 = MessageBuilder.withPayload("订单1").setHeader("price", 600).build();
        log.info("生产者发送消息: {}", message1);
        this.rocketMQTemplate.sendOneWay((RocketMQConstant.TOPIC_PREFIX + "starter-sql-filter:phone"), message1);
        Message<String> message2 = MessageBuilder.withPayload("订单2").setHeader("price", 420).build();
        log.info("生产者发送消息: {}", message2);
        this.rocketMQTemplate.sendOneWay((RocketMQConstant.TOPIC_PREFIX + "starter-sql-filter:phone"), message2);
        Message<String> message3 = MessageBuilder.withPayload("订单3").setHeader("price", 480).build();
        log.info("生产者发送消息: {}", message3);
        this.rocketMQTemplate.sendOneWay((RocketMQConstant.TOPIC_PREFIX + "starter-sql-filter"), message3);
        Message<String> message4 = MessageBuilder.withPayload("订单4").setHeader("price", 500).build();
        log.info("生产者发送消息: {}", message4);
        this.rocketMQTemplate.sendOneWay((RocketMQConstant.TOPIC_PREFIX + "starter-sql-filter:phone"), message4);
        return CommonResult.success();
    }

    @PostMapping("/transaction/{number}")
    public CommonResult<?> sendTransactionMessage(@PathVariable Integer number) {
        log.info("接收到事务请求，准备执行生产者本地事务...");
        Message<String> message = MessageBuilder.withPayload("通知消费者执行本地事务的事务消息").build();
        TransactionSendResult transactionSendResult = this.rocketMQTemplate.sendMessageInTransaction((RocketMQConstant.TOPIC_PREFIX + "starter-transaction"), message, number);
        log.info("生产者发送状态: {}", transactionSendResult.getSendStatus().toString());
        log.info("本地事务执行结果: {}", transactionSendResult.getLocalTransactionState().toString());
        return CommonResult.success(transactionSendResult);
    }


}
