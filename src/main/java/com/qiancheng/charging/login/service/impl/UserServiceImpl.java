package com.qiancheng.charging.login.service.impl;

import com.qiancheng.charging.login.dao.UserDao;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.login.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSerivce{

    @Autowired
    private UserDao userDao;


    @Override
    public String login(String name){
        User user = new User();
        user.setName(name);
        Integer a = userDao.insert_hr_position(user);
        return String.valueOf(a);
    }

}
