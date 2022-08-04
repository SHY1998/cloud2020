package com.shy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shy
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientConfig3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientConfig3355.class,args);
    }
}
