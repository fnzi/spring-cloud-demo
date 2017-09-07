package com.ias.agdis.serviceb.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-a", fallback = ServiceAClient.ServiceBClientFallback.class)
public interface ServiceAClient {
    @GetMapping(value = "/user/{username}")
    User getUser(@PathVariable("username") String username);

    @Component
    class ServiceBClientFallback implements ServiceAClient {

        private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBClientFallback.class);

        @Override
        public User getUser(String username) {
            LOGGER.info("异常发生，进入fallback方法");
            return new User();
        }
    }
}