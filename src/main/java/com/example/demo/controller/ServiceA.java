package com.example.demo.controller;

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
	}
	

