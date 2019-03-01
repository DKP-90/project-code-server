package com.help.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
//
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name="project-client")
public class ProjectCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCodeApplication.class, args);
	}
    @Configuration
    class Config
    {
    @LoadBalanced	
    @Bean
    public RestTemplate restTemplate()
    {
    	////
    	return new RestTemplate();
    }
    }
}

