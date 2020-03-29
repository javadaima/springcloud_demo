package com.chen.sf_demo.template.service.impl;

import com.chen.sf_demo.template.dao.UserDAO;
import com.chen.sf_demo.template.model.User;
import com.chen.sf_demo.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private UserDAO userDAO;

    public void createUser(){
        User user = new User();

        user.setName("chenzhigang");
        List<User> users = userDAO.findByName(user.getName());
        if(users.size()>0){
            return;
        }
        User save = userDAO.save(user);
        System.out.println(123);
    }
}
