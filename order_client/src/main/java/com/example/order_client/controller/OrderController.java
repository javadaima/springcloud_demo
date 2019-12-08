package com.example.order_client.controller;

import com.example.order_client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("/addOrder")
    public String addOrder(){

        ///String order = restTemplate.getForObject("http://user/getUser", String.class);

        ServiceInstance serverInstance = loadBalancerClient.choose("user");

        String url = String.format("http://%s:%s", serverInstance.getHost(), serverInstance.getPort()+"/getUser");

        RestTemplate restTemplate = new RestTemplate();

        String order = restTemplate.getForObject(url, String.class);

        System.out.println(serverInstance.getPort()+order);

        return serverInstance.getPort()+"正在创建订单";

    }

    @RequestMapping("deleteOrder")
    public String deletaUser(){

        String msg = userService.deleteUser();

        System.out.println(msg);

        return msg;

    }
}
