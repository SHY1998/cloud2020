package com.shy.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author shy
 * @version 1.0
 */
@Service
public class PaymentService {
    public String paymentInfoOk(Integer id)
    {
        return "线程池: "+ Thread.currentThread().getName() + " payment_ok" + id + "\t" + "0______0";
    }


    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            //3秒钟以内就是正常的业务逻辑
    })
    public String paymentInfoTimeOut(Integer id)
    {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+ Thread.currentThread().getName() + " payment_timeout" + id + "\t" + "000000";
    }

    public String paymentInfoTimeOutHandler(Integer id)
    {
        return "线程池: "+ Thread.currentThread().getName() + " paymentInfoTimeOutHandle /(ㄒoㄒ)/~~r Id: " + id ;

    }


}
