package com.example.order_client.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user")
public interface UserService {

    @RequestMapping("/deleteUser")

    public String deleteUser();

}
