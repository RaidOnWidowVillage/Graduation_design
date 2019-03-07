package com.qiancheng.charging.salary.service.impl;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Salary;
import com.qiancheng.charging.salary.dao.SalaryDao;
import com.qiancheng.charging.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryDao salaryDao;

    @Override
    public ServerResponse<Integer> addSalary(Salary sal) {
        Integer sals = salaryDao.insert_hr_salary(sal);
        if(sals >0){
            return ServerResponse.createBySuccess("增加薪资成功",sals);
        }else{
            return ServerResponse.createByErrorMessage("增加薪资失败");
        }
    }

    @Override
    public ServerResponse<Integer> deleteSalary(Salary sal) {
        Integer sals = salaryDao.delete_hr_salary(sal);
        if(sals >0){
            return ServerResponse.createBySuccess("删除薪资成功",sals);
        }else{
            return ServerResponse.createByErrorMessage("删除薪资失败");
        }
    }

    @Override
    public ServerResponse<Integer> updateSalary(Salary sal) {
        Integer sals = salaryDao.update_hr_salary(sal);
        if(sals >0){
            return ServerResponse.createBySuccess("更新薪资成功",sals);
        }else{
            return ServerResponse.createByErrorMessage("更新薪资失败");
        }
    }

    @Override
    public ServerResponse queryAllSalary() {
        List<Salary> sals = salaryDao.select_hr_salary();
        if(sals != null){
            return ServerResponse.createBySuccess("查询薪资成功",sals);
        }else{
            return ServerResponse.createByErrorMessage("查询薪资失败");
        }

    }

    @Override
    public ServerResponse queryByName(Salary sal) {
        List<Salary> sals = salaryDao.querybyname(sal);
        if(sals != null){
            return ServerResponse.createBySuccess("查询薪资成功",sals);
        }else{
            return ServerResponse.createByErrorMessage("查询薪资失败");
        }

    }
}
