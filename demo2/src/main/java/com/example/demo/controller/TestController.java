package com.example.demo.controller;



import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;


@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("test")
    public String test1(){
        return "index2";
    }
    @Test
    public void test(){

        StringBuffer str1 = new StringBuffer("ceshi");
        str1.append("123");
        System.out.println(str1);
        Class<? extends TestController> aClass = this.getClass();
        Annotation[] annotations = aClass.getAnnotations();

    }



}
