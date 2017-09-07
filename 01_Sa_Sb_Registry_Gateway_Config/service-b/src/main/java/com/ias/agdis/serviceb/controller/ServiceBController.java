package com.ias.agdis.serviceb.controller;

import com.ias.agdis.serviceb.client.ServiceAClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

//    @Autowired
//    EurekaDiscoveryClient discoveryClient;

    @Value("${msg:unknown}")
    private String msg;

    @Autowired
    ServiceAClient serviceAClient;

    @GetMapping(value = "/")
    public String printServiceB() {
        return " (" + serviceAClient.getUser("fnzi").getUsername() + ")" + "===>Say " + msg;
    }
}
