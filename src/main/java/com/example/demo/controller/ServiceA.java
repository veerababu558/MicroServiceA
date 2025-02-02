package com.example.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ServiceA")
public class ServiceA {
	
	@Autowired
	FeignClientinterface feignClientinterface;
	
	@GetMapping("/v1/serviceA")	
		String display() {
			return "Message from Service-A";
		}
	
	@GetMapping("/v1/callSeviceB")
	
	String callSerivceB() {
		return feignClientinterface.callSerivceB();
	}
	@GetMapping("/v1/ip")
	 public Map<String, String> getIpAddress() {
        Map<String, String> response = new HashMap<>();
        try {
            // Get the local IP address of the ECS task
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            response.put("ipAddress", ipAddress);
        } catch (UnknownHostException e) {
            response.put("error", "Failed to get IP address: " + e.getMessage());
        }
        return response;
    }
	}
	

