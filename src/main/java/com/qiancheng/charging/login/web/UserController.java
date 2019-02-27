package com.qiancheng.charging.login.web;

import com.qiancheng.charging.entity.Position;
import com.qiancheng.charging.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login" , method = {RequestMethod.POST})
    @ResponseBody
    public String login(Position ps){
        return userService.login(ps);
    }
}
