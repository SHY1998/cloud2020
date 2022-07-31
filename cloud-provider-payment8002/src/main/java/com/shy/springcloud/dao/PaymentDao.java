package com.shy.springcloud.dao;

import com.shy.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shy
 * @version 1.0
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    
    public Payment getPaymentById(@Param("id") Long id);
}
