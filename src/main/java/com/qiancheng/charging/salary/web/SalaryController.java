package com.qiancheng.charging.salary.web;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Salary;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value="/add_salary" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse addSalary(Salary sal,HttpServletRequest request){
        HttpSession session = request.getSession();
        User res = (User)session.getAttribute("userMsg");
        String username = res.getUsername();
        sal.setCreateUser(username);
        sal.setUpdateUser(username);
        return salaryService.addSalary(sal);
    }
    @RequestMapping(value="/delete_salary" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteSalary(Salary sal,HttpServletRequest request){
        HttpSession session = request.getSession();
        User res = (User)session.getAttribute("userMsg");
        String username = res.getUsername();
        sal.setUpdateUser(username);
        return salaryService.deleteSalary(sal);
    }
    @RequestMapping(value="/update_salary" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateSalary(Salary sal,HttpServletRequest request){
        HttpSession session = request.getSession();
        User res = (User)session.getAttribute("userMsg");
        String username = res.getUsername();
        sal.setUpdateUser(username);
        return salaryService.updateSalary(sal);
    }
    @RequestMapping(value="/select_salary" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse selectSalary(){
        return  salaryService.queryAllSalary();
    }
    @RequestMapping(value="/querybyname" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse querybynames(Salary sal,HttpServletRequest request){
        HttpSession session = request.getSession();
        User res = (User)session.getAttribute("userMsg");
        String username = res.getUsername();
        sal.setUpdateUser(username);
        return salaryService.queryByName(sal);
    }
}
