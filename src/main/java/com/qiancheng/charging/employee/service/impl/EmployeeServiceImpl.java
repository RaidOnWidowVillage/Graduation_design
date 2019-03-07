package com.qiancheng.charging.employee.service.impl;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.employee.dao.EmployeeDao;
import com.qiancheng.charging.employee.entity.EmployeeBO;
import com.qiancheng.charging.employee.service.EmployeeService;
import com.qiancheng.charging.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ServerResponse<Integer> delEmploy(Employee employee) {
        employee.setStatus(9);//删除员工状态
        int result = employeeDao.del_Employee(employee);
        //如果删除一条成功，返回1
        if(result>0){
            return ServerResponse.createBySuccessMessage("删除员工成功");
        }else{
            return ServerResponse.createByErrorMessage("删除员工失败");
        }
    }

    @Override
    public ServerResponse<Integer> updateEmploy(Employee employee) {
        int result = employeeDao.update_Employee(employee);
        //如果更新一条成功，返回1
        if(result>0){
            return ServerResponse.createBySuccessMessage("更新员工成功");
        }else{
            return ServerResponse.createByErrorMessage("更新员工失败");
        }
    }

    @Override
    public ServerResponse<List<EmployeeBO>> selectAllEmploy(Employee employee) {
        List<EmployeeBO> result = employeeDao.select_All_Employee(employee);
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse<EmployeeBO> selectOneEmployee(String id) {
        EmployeeBO result = employeeDao.select_One_Employee(id);
        return ServerResponse.createBySuccess(result);
    }


}
