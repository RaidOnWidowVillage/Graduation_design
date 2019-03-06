package com.qiancheng.charging.login.web;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.common.SessionContext;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.login.service.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse login(HttpServletRequest request, User user){
        //数据验证
        if(StringUtils.isBlank(user.getUsername()) && StringUtils.isBlank(user.getPassword())){
            return ServerResponse.createByErrorMessage("用户名密码为空");
        }else{
            //如果没有数据，返回错误
            ServerResponse result = userService.login(user);
            if(result.getStatus()==-1){
                return result;
            }else{
                //成功
                User res = (User) result.getData();
                //密码正确
                if(user.getPassword().equals(res.getPassword())){
                    HashedMap map = new HashedMap();
                    HttpSession session = request.getSession();
                    //把数据放在session中
                    session.setAttribute("userMsg",res);
                    SessionContext.AddSession(session);
                    //更新上次登陆时间
                    userService.lastLoginTime(res.getId());
                    return ServerResponse.createBySuccessMessage("登录成功");
                }else{
                    return ServerResponse.createByErrorMessage("账户名与密码错误");
                }
            }
        }
    }

    @RequestMapping(value="/checkSession" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse checkSession(){
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value="/getUserInfo" , method = {RequestMethod.GET})
    @ResponseBody
    public ServerResponse getInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        User res = (User)session.getAttribute("userMsg");
        if(res!=null){
            return ServerResponse.createBySuccess("获取用户信息成功",res);
        }else{
            return ServerResponse.createByErrorMessage("获取用户信息失败");
        }
    }

    @RequestMapping(value="/getAllUser" , method = {RequestMethod.GET})
    @ResponseBody
    public ServerResponse getAllUser(){
        return userService.selectAllUser();
    }


    @RequestMapping(value="/getOneUser" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse getUserById(String id){
        return userService.selectUserById(id);
    }

    @RequestMapping(value="/UpdateUser" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse UpdateUserById(User user){
        return userService.updateUserById(user);
    }
}
