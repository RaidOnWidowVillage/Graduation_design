package com.qiancheng.charging.salary.web;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Department;
import com.qiancheng.charging.entity.Salary;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.department.service.DepartmentService;
import com.qiancheng.charging.salary.service.SalaryService;
import javafx.scene.control.Alert;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value="/add_salary" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse addSalary(Salary sal){
        sal.setCreateUser("yananding");
        sal.setUpdateUser("yananding");
        return salaryService.addSalary(sal);
    }
    @RequestMapping(value="/delete_salary" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteSalary(Salary sal){
        sal.setUpdateUser("yananding");
        return salaryService.deleteSalary(sal);
    }
    @RequestMapping(value="/update_salary" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateSalary(Salary sal){
        sal.setUpdateUser("yananding");
        return salaryService.updateSalary(sal);
    }
    @RequestMapping(value="/select_salary" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse selectSalary(){
        return  salaryService.queryAllSalary();
    }
    @RequestMapping(value="/querybyname" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse querybynames(Salary sal){
        sal.setUpdateUser("yananding");
        return salaryService.queryByName(sal);
    }
}
