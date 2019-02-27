package com.qiancheng.charging.employee.service;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Employee;

public interface EmployeeService {
    ServerResponse<Integer> addEmploy(Employee employee); //增加员工
    ServerResponse<Integer> delEmploy(Employee employee); //删除员工
    ServerResponse<Integer> updateEmploy(Employee employee); //更新员工
    ServerResponse<Integer> selectAllEmploy(Employee employee); //查询所有员工
}
