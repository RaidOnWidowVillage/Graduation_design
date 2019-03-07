package com.qiancheng.charging.login.service.impl;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.login.dao.UserDao;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public ServerResponse<String> register(User user){
        Integer result = userDao.insert_user(user);
        if(result>0){
            return ServerResponse.createBySuccess("注册成功");
        }else{
            return ServerResponse.createByErrorMessage("注册失败");
        }

    }

    @Override
    public ServerResponse login(User user) {
        User result = userDao.selectUserByUsername(user);
        if(result!=null){
            return ServerResponse.createBySuccess(result);
        }else{
            return ServerResponse.createByErrorMessage("账号不存在");
        }

    }

    @Override
    public ServerResponse lastLoginTime(String id) {
        Integer result = userDao.updateLastLoginTime(id);
        if(result>0){
            return ServerResponse.createBySuccess("更新上次登陆时间成功");
        }else{
            return ServerResponse.createByErrorMessage("更新上次登陆时间失败");
        }
    }

    @Override
    public ServerResponse selectAllUser() {
//        PageHelper.startPage(page,rows);

        //执行查询
        List<User> result = userDao.selectAllUser();
//
//        //获取分页信息对象
//        PageInfo<User> pageInfo = new PageInfo<>(result);

        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse<User> selectUserById(String id) {
        User result = userDao.selectUserById(id);

        if(null != result){
            return ServerResponse.createBySuccess(result);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }

    @Override
    public ServerResponse<Integer> updateUserById(User user) {
        Integer result = userDao.updateUserById(user);

        if(result>0){
            return  ServerResponse.createBySuccessMessage("更新成功");
        }else{
            return ServerResponse.createByErrorMessage("更新失败");
        }

    }

}
