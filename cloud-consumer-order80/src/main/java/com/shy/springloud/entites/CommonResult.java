package com.shy.springloud.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author shy
 * @version 1.0
 * 前后端交互信息的格式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message)
    {
        this(code,message,null);
    }
}
