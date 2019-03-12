package com.qiancheng.charging.employee.web;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.employee.entity.EmployeeBO;
import com.qiancheng.charging.employee.service.EmployeeService;
import com.qiancheng.charging.entity.Employee;
import com.qiancheng.charging.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //新增员工
    @RequestMapping(value="/add_employee" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse AddEmployee(Employee employee){
        employee.setCreateUser("jayne");//设置创建者
        employee.setUpdateUser("jayne");//设置修改者
        return employeeService.addEmploy(employee);
    }

    //删除员工
    @RequestMapping(value="/del_employee" , method = {RequestMethod.GET})
    @ResponseBody
    public ServerResponse DelEmployee(Employee employee){
        return employeeService.delEmploy(employee);
    }

    //更新员工信息
    @RequestMapping(value="/update_employee" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse UpdateEmployee(Employee employee){
        employee.setUpdateUser("jayne");//设置修改者
        //数据验证
        if(employee.getId()==null&&employee.getName()==null&&employee.getPhone()==null&&employee.getEmail()==null&&employee.getAddress()==null&&employee.getDepartmentId()==null&&employee.getSalaryId()==null&&employee.getSalaryId()==null){
            return ServerResponse.createByErrorMessage("参数错误");
        }else{
            return employeeService.updateEmploy(employee);
        }

    }
    //更新个人信息
    @RequestMapping(value="/update_personal" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse UpdatePersonal(Employee employee){
        employee.setUpdateUser("jayne");//设置修改者
        //数据验证
        if(employee.getPhone()==null&&employee.getEmail()==null&&employee.getAddress()==null){
            return ServerResponse.createByErrorMessage("参数错误");
        }else{
            return employeeService.updatePersonal(employee);
        }

    }

    //查询员工信息
    @RequestMapping(value="/select_all_employee" , method = {RequestMethod.GET})
    @ResponseBody
    public ServerResponse SelectAllEmployee(Employee employee){

        return employeeService.selectAllEmploy(employee);
    }

    //查询员工信息
    @RequestMapping(value="/select_one_employee" , method = {RequestMethod.GET})
    @ResponseBody
    public ServerResponse SelectOneEmployee(String id){ return employeeService.selectOneEmployee(id);
    }
}
