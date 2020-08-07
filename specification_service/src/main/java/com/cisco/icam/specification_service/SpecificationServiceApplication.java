package com.cisco.icam.specification_service;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpecificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpecificationServiceApplication.class, args);
    }

}
