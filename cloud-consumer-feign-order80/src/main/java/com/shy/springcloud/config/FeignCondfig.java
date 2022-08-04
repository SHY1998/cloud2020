package com.shy.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author shy
 * @version 1.0
 */
@Configuration
public class FeignCondfig {
    @Bean
    Logger.Level feignLoggerlevel()
    {
        return Logger.Level.FULL;
    }
}
