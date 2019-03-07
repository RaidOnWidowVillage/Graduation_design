package com.qiancheng.charging.salary.service;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Salary;

import java.util.List;

public interface SalaryService {
    //添加部门信息
    ServerResponse <Integer> addSalary(Salary sal);
    //删除部门信息
    ServerResponse<Integer> deleteSalary(Salary sal);
    //更新部门信息
    ServerResponse <Integer> updateSalary(Salary sal);
    //查询部门信息
    ServerResponse <List> queryAllSalary();
    //按照部门名称查询部门信息
    ServerResponse<List> queryByName(Salary sal);
}
