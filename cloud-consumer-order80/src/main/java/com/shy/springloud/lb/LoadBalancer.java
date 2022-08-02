package com.shy.springloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author shy
 * @version 1.0
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}
