package com.shy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author shy
 * @version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "----------PaymentFallbackService fall backk paymentInfoOk,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "----------PaymentFallbackService fall backk paymentInfoTimeOut,/(ㄒoㄒ)/~~";

    }
}
