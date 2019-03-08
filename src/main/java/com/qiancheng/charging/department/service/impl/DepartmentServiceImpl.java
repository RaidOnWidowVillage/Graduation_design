package com.qiancheng.charging.department.service.impl;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.department.dao.DepartmentDao;
import com.qiancheng.charging.department.entity.DepartmentBO;
import com.qiancheng.charging.entity.Department;
import com.qiancheng.charging.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public ServerResponse addDepartment(Department dep) {
        Integer a = departmentDao.insert_hr_department(dep);
        //如果增加一条成功，返回1
        if(a >0){
            return ServerResponse.createBySuccess("增加部门成功",dep);
        }else{
            return ServerResponse.createByErrorMessage("增加部门失败");
        }
    }

    @Override
    public ServerResponse deleteDepartment(Department dep) {
        Integer b = departmentDao.delete_hr_department(dep);
//        如果删除一条成功，返回1
        if(b >0){
            return ServerResponse.createBySuccess("删除部门成功",dep);
        }else{
            return ServerResponse.createByErrorMessage("删除部门失败");
        }
    }

    @Override
    public ServerResponse<Integer> updateDepartment(Department dep) {
        Integer c = departmentDao.update_hr_department(dep);
        //如果更新一条成功，返回1
        if(c>0){
            return ServerResponse.createBySuccessMessage("更新部门成功");
        }else{
            return ServerResponse.createByErrorMessage("更新部门失败");
        }
    }

    @Override
    public ServerResponse<List<DepartmentBO>> queryAllDepartment() {
        List<DepartmentBO> dep = departmentDao.select_hr_department();
        //如果查询一条成功，返回1
        if (dep != null) {
            return ServerResponse.createBySuccess("查询部门成功",dep);
        } else {
            return ServerResponse.createByErrorMessage("查询部门失败");
        }
    }

    @Override
    public ServerResponse<List<DepartmentBO>> queryBy(Department dep) {
        String name = dep.getName();
        String manager = dep.getManager();
        List<DepartmentBO> deps = departmentDao.queryby_hr_department(name, manager);
        if (deps != null) {
            return ServerResponse.createBySuccess("查询部门成功",deps);
        } else {
            return ServerResponse.createByErrorMessage("查询部门失败");
        }
    }
}
