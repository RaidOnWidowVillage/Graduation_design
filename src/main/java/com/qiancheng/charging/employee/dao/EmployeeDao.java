package com.qiancheng.charging.employee.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.entity.Employee;
import org.apache.ibatis.annotations.Insert;

@MyBatisDao
public interface EmployeeDao {
    @Insert("insert into hr_employee(id,name,gender,phone,email,address,departmentId,positionId,status,salaryId,createtime,updatetime,createuser,updateuser) " +
            "values(UUID(),#{name},#{gender},#{phone},#{email},#{address},#{departmentId},#{positionId},#{status},#{salaryId},now(),now(),#{createUser},#{updateUser})")
    int add_Employee(Employee employee);
}
