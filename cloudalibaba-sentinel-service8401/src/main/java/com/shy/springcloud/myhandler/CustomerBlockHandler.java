package com.shy.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shy.springcloud.entites.CommonResult;
import com.shy.springcloud.entites.Payment;

/**
 * @author shy
 * @version 1.0
 */

public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException blockException)
    {
        return new CommonResult(4444, "按客户自定义,blockException------------1");
    }

    public static CommonResult handlerException2(BlockException blockException)
    {
        return new CommonResult(4444, "按客户自定义,blockException------------2");
    }
}
