package com.shy.springcloud.service;

import com.shy.springcloud.entites.CommonResult;
import com.shy.springcloud.entites.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shy
 * @version 1.0
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> patmentSQL(@PathVariable("id")Long id);

}
