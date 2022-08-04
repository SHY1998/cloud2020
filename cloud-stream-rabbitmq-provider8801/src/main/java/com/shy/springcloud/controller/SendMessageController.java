package com.shy.springcloud.controller;

import com.shy.springcloud.service.IMessageProvider;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shy
 * @version 1.0
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMsg")
    public String sendMessage()
    {
        return iMessageProvider.send();
    }
}
