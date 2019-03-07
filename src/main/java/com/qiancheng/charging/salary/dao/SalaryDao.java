package com.qiancheng.charging.salary.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.entity.Salary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@MyBatisDao
public interface SalaryDao {
    //添加薪资信息
    @Insert("insert into hr_salary(id,name,basicSalary,safe,fund,tax,createTime,updateTime,createUser,updateUser) values(UUID(),#{name},#{basicSalary},#{safe},#{fund},#{tax},now(),now(),#{createUser},#{updateUser})")
    Integer insert_hr_salary(Salary sal);
    //删除部门信息
    @Delete("delete from hr_salary where id=#{id}")
    Integer delete_hr_salary(Salary sal);
    //更新部门信息
    @Update("update hr_salary set name=#{name},basicSalary=#{basicSalary},safe=#{safe},fund=#{fund},tax=#{tax},updatetime=(now()),updateUser=#{updateUser} where id=#{id}")
    Integer update_hr_salary(Salary sal);
    //查询所有部门信息
    @Select("select id,name,basicSalary,safe,fund,tax from hr_salary")
    List<Salary> select_hr_salary();
    //根据薪资名称查询信息
    @Select("select id,name,basicSalary,safe,fund,tax from hr_salary where name = #{name}")
    List<Salary> querybyname(Salary sal);
}
