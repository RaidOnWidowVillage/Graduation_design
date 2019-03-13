package com.qiancheng.charging.login.service.impl;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.employee.service.EmployeeService;
import com.qiancheng.charging.login.dao.UserDao;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.login.entity.UserVO;
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
        Integer result2 =userDao.insert_employee(user);
        if(result>0&&result2>0){
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
    public ServerResponse selectAllUser(User user) {
//        PageHelper.startPage(page,rows);

        //执行查询
        List<User> result = userDao.selectAllUser(user);
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

    @Override
    public ServerResponse deleteUserById(String id) {
        Integer result = userDao.deleteUserById(id);
        if(result>0){
            return  ServerResponse.createBySuccessMessage("删除成功");
        }else{
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    @Override
    public ServerResponse selectByUserName(User user) {
        Integer result = userDao.selectByUsername(user);
        if(result >= 1){
            return  ServerResponse.createByErrorMessage("用户名已注册");
        }else{
            return  ServerResponse.createBySuccessMessage("可以注册");
        }
    }

}
