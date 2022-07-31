package com.shy.springcloud.controller;

import com.shy.springcloud.entites.CommonResult;
import com.shy.springcloud.entites.Payment;
import com.shy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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


    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*********插入结果：" + result);
        if (result > 0)
        {
            return new CommonResult(200,"插入数据库成功",result);
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
            return new CommonResult(200,"查询成功",payment);
        } else {
            return new CommonResult(444,"查询失败,查询id：" + id,null);
        }
    }
}
