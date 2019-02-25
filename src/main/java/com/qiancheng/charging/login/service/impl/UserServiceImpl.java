package com.qiancheng.charging.login.service.impl;

import com.qiancheng.charging.entity.Position;
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
    public String login(Position ps){
        Integer a = userDao.insert_hr_position(ps);
        return String.valueOf(a);
    }

}
