package com.example.user_client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/getUser")
    public String getUser(){
        return "已查询到一个人的信息";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(){
        return "正在删除人员";
    }
}
