package com.qiancheng.charging.employee.service.impl;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.employee.dao.EmployeeDao;
import com.qiancheng.charging.employee.service.EmployeeService;
import com.qiancheng.charging.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public ServerResponse<Integer> addEmploy(Employee employee) {
        int result = employeeDao.add_Employee(employee);
        //如果增加一条成功，返回1
        if(result>0){
            return ServerResponse.createBySuccessMessage("增加员工成功");
        }else{
            return ServerResponse.createByErrorMessage("增加员工失败");
        }

    }
}
