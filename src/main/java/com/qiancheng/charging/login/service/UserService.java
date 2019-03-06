package com.qiancheng.charging.login.service;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.User;

public interface UserService {
    //  注册
    ServerResponse<String> register (User user);
    //登陆
    ServerResponse login(User user);

    ServerResponse lastLoginTime();
}
