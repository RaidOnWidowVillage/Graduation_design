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

    @RequestMapping(value="/add_employee" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse AddEmployee(Employee employee){
        return employeeService.addEmploy(employee);
    }
}
