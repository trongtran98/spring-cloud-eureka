package com.trongtran.springclouddiscovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discover")
    public String discoverService() {
        List<ServiceInstance> instances =
                discoveryClient.getInstances("Eureka Client Example");
        return instances.get(0).getUri().toString();
    }
}