package com.qiancheng.charging.employee.service;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Employee;

public interface EmployeeService {
    ServerResponse<Integer> addEmploy(Employee employee);
}
