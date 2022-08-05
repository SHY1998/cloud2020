package com.shy.springcloud.controller;

import com.shy.springcloud.entites.CommonResult;
import com.shy.springcloud.entites.Payment;
import com.shy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shy
 * @version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*********插入结果：" + result);
        if (result > 0)
        {
            return new CommonResult(200,"插入数据库成功,serverPort" + serverPort,result);
        } else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }


    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********插入结果：" + payment);
        if (payment != null)
        {
            return new CommonResult(200,"查询成功,serverPort" + serverPort,payment);
        } else {
            return new CommonResult(444,"查询失败,查询id：" + id,null);
        }
    }


    @GetMapping("/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*********service:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }
    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout()
    {
        try {
//            log.info("yime");
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }
    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
