package com.shy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shy
 * @version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderConsulController {

    public static final String INVOKE_URL = "http://cloud-providerconsul-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul",String.class);
        return result;
    }
}
