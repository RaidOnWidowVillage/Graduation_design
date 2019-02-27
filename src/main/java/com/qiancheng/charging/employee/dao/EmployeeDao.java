package com.qiancheng.charging.employee.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@MyBatisDao
public interface EmployeeDao {
    @Insert("insert into hr_employee(id,name,gender,phone,email,address,departmentId,positionId,status,salaryId,createtime,updatetime,createuser,updateuser,contact) " +
            "values(UUID(),#{name},#{gender},#{phone},#{email},#{address},#{departmentId},#{positionId},#{status},#{salaryId},now(),now(),#{createUser},#{updateUser},#{contact})")
    int add_Employee(Employee employee);

    @Update("update hr_employee SET status = #{status},updatetime = now(),updateuser=#{updateUser}\n" +
            "WHERE id = #{id}")
    int del_Employee(Employee employee);

    @Update("update hr_employee SET name = #{name},gender = #{gender},phone = #{phone},email = #{email},address = #{address},departmentId = #{departmentId},positionId = #{positionId},status = #{status},salaryId = #{salaryId},updatetime =now(),updateuser = #{updateUser},contact = #{contact}" +
            "WHERE id = #{id}")
    int update_Employee(Employee employee);
}
