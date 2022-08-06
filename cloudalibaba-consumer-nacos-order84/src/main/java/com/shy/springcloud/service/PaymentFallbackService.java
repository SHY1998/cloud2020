package com.shy.springcloud.service;

import com.shy.springcloud.entites.CommonResult;
import com.shy.springcloud.entites.Payment;
import org.springframework.stereotype.Component;

/**
 * @author shy
 * @version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> patmentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,-----------PaymentFallbackService");
    }
}
