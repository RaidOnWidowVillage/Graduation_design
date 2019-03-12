package com.qiancheng.charging.employee.service;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.employee.entity.EmployeeBO;
import com.qiancheng.charging.entity.Employee;

import java.util.List;

public interface EmployeeService {
    ServerResponse<Integer> addEmploy(Employee employee); //增加员工
    ServerResponse<Integer> delEmploy(Employee employee); //删除员工
    ServerResponse<Integer> updateEmploy(Employee employee); //更新员工
    ServerResponse<List<EmployeeBO>> selectAllEmploy(Employee employee); //查询所有员工
    ServerResponse<EmployeeBO> selectOneEmployee(String id);//查询员工信息
    ServerResponse<Integer> updatePersonal(Employee employee); //更新个人
}
