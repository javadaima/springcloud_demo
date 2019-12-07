package com.example.ribbon2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableDiscoveryClient
public class Ribbon2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ribbon2Application.class, args);
    }
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){

        return new RestTemplate();
        new ThreadPoolExecutor();
        Connection;

    }

}
