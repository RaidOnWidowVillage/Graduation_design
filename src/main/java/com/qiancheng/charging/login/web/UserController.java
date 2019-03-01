package com.qiancheng.charging.login.web;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.common.SessionContext;
import com.qiancheng.charging.entity.User;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserService userService;

    @RequestMapping(value="/login" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse login(HttpServletRequest request, User user){
        if(StringUtils.isBlank(user.getUsername()) && StringUtils.isBlank(user.getPassword())){
            return ServerResponse.createByErrorMessage("用户名密码为空");
        }else{
            if(user.getUsername().equals("111")){
                HashedMap map = new HashedMap();
                HttpSession session = request.getSession();
                session.setAttribute("userMsg",0);
                SessionContext.AddSession(session);
                map.put("loginStatus",0);
                map.put("url","/admin/index.html");
                return ServerResponse.createBySuccess("登录成功",map);
            }else{
                return ServerResponse.createByErrorMessage("账户名与密码错误");
            }

        }
    }

    @RequestMapping(value="/checkSession" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse checkSession(){
        return ServerResponse.createBySuccess();
    }


}
