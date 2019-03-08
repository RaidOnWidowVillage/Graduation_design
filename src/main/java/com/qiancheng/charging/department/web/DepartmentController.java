package com.qiancheng.charging.department.web;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Department;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value="/add_department" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse addDepartment(Department dep,HttpServletRequest request){
        HttpSession session = request.getSession();
        User res = (User)session.getAttribute("userMsg");
        String username = res.getUsername();
        dep.setCreateUser(username);
        dep.setUpdateUser(username);
        return departmentService.addDepartment(dep);
    }
    @RequestMapping(value="/delete_department" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteDepartment(Department dep,HttpServletRequest request){
        HttpSession session = request.getSession();
        User res = (User) session.getAttribute("userMsg");
        String username = res.getUsername();
        dep.setUpdateUser(username);
        return departmentService.deleteDepartment(dep);
    }
    @RequestMapping(value="/update_department" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateDepartment(Department dep,HttpServletRequest request){
        HttpSession session = request.getSession();
        User res = (User) session.getAttribute("userMsg");
        String username = res.getUsername();
        dep.setUpdateUser(username);
        return departmentService.updateDepartment(dep);
    }
    @RequestMapping(value="/select_department" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse selectDepartment(){
        return  departmentService.queryAllDepartment();
    }
    @RequestMapping(value="/queryby" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse querybyname(Department depts,HttpServletRequest request){
        HttpSession session = request.getSession();
        User res = (User) session.getAttribute("userMsg");
        String username = res.getUsername();
        depts.setUpdateUser(username);
        return departmentService.queryBy(depts);
    }
}
