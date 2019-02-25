package com.qiancheng.charging.login.web;

import com.qiancheng.charging.login.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserSerivce userSerivce;

    @RequestMapping(value="/login" , method = {RequestMethod.GET})
    @ResponseBody
    public String login(String name){
        return userSerivce.login(name);
    }
}
