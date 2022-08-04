package com.shy.springcloud.service.impl;

import com.shy.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 * @author shy
 * @version 1.0
 */
//定义消息的推送管道
@EnableBinding(Source.class)
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("************serial: " + serial);
        return null;
    }
}
