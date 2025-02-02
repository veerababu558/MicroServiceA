package com.example.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Service-B", url = "http://service-b:8092")
public interface FeignClientinterface {
    @GetMapping("/ServiceB/api/resource")
    String callSerivceB();
}
