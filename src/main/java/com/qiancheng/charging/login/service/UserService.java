package com.qiancheng.charging.login.service;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.User;

import java.util.List;

public interface UserService {
    // 注册
    ServerResponse<String> register (User user);
    //登陆
    ServerResponse login(User user);
    //更新上次登陆时间
    ServerResponse lastLoginTime(String id);
    //获取所有用户
    ServerResponse selectAllUser(User user);
    //查询用户
    ServerResponse<User> selectUserById(String id);
    //更新用户
    ServerResponse<Integer> updateUserById(User user);
    //删除用户
    ServerResponse deleteUserById(String id);
}
