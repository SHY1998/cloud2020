package com.shy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shy
 * @version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //全局的
public class OrderHystrixController  {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentInfoOk(id);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//            //3秒钟以内就是正常的业务逻辑
//    })
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id)
    {
        int age = 10 / 0;
        String result = paymentService.paymentInfoTimeOut(id);
        return result;
    }

    public String paymentInfoTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {

        return "我是消费者80，对方支付系统繁忙";
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
