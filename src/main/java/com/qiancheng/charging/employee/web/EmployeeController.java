package com.qiancheng.charging.employee.web;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.employee.service.EmployeeService;
import com.qiancheng.charging.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //删除员工，逻辑删除
    @RequestMapping(value="/del_employee" , method = {RequestMethod.GET})
    @ResponseBody
    public ServerResponse DelEmployee(Employee employee){
        employee.setUpdateUser("jayne");//设置修改者
        return employeeService.delEmploy(employee);
    }

    //更新员工信息
    @RequestMapping(value="/update_employee" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse UpdateEmployee(Employee employee){
        employee.setUpdateUser("jayne");//设置修改者
        //数据验证
        if(employee.getId()==null&&employee.getName()==null&&employee.getPhone()==null&&employee.getAddress()==null&&employee.getDepartmentId()==null&&employee.getPositionId()==null&&employee.getSalaryId()==null&&employee.getSalaryId()==null){
            return ServerResponse.createByErrorMessage("参数错误");
        }else{
            return employeeService.updateEmploy(employee);
        }

    }

    //查询员工信息
    @RequestMapping(value="/select_all_employee" , method = {RequestMethod.GET})
    @ResponseBody
    public ServerResponse SelectAllEmployee(){
        return employeeService.selectAllEmploy();
    }
}
