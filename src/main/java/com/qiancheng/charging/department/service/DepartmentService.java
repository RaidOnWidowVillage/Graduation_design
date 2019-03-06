package com.qiancheng.charging.department.service;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Department;

import java.util.List;

public interface DepartmentService {
    //添加部门信息
    ServerResponse <Integer> addDepartment(Department dep);
    //删除部门信息
    ServerResponse<Integer> deleteDepartment(Department dep);
    //更新部门信息
    ServerResponse <Integer> updateDepartment(Department dep);
    //查询部门信息
    ServerResponse <List> queryAllDepartment();
    //按照部门名称查询部门信息
//    ServerResponse <Department> queryByName(String name);
}
