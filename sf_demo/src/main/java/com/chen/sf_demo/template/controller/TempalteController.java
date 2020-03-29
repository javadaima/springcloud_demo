package com.chen.sf_demo.template.controller;


import com.alibaba.fastjson.JSON;
import com.chen.sf_demo.template.dao.UserDAO;
import com.chen.sf_demo.template.model.User;
import com.chen.sf_demo.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/test")
public class TempalteController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/test")
    public void test(){
        templateService.createUser();
    }
    @RequestMapping("/testStream")
    public void testStream(){
        List<User> users = userDAO.findAll();
        Map<String,List<User>> map = users.stream().collect(Collectors.groupingBy(User::getSex));
        for (Map.Entry<String, List<User>> entry : map.entrySet()) {
            System.out.println("分组" + JSON.toJSONString(entry));
        }
        //分组求和
        Map<String, LongSummaryStatistics> collect = users.stream().collect(
                Collectors.groupingBy(User::getSex,
                        Collectors.summarizingLong(User::getAge)));
        for (Map.Entry<String, LongSummaryStatistics> entry : collect.entrySet()) {
            LongSummaryStatistics longSummaryStatistics = entry.getValue();
            System.out.println("----------------key----------------" + entry.getKey());
            System.out.println("求和:" + longSummaryStatistics.getSum());
            System.out.println("求平均" + longSummaryStatistics.getAverage());
            System.out.println("求最大:" + longSummaryStatistics.getMax());
            System.out.println("求最小:" + longSummaryStatistics.getMin());
            System.out.println("求总数:" + longSummaryStatistics.getCount());
        }
    }

}
