package com.qiancheng.charging.department.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@MyBatisDao
public interface DepartmentDao {
    //添加部门信息
    @Insert("insert into hr_department(id,name,createTime,updateTime,createUser,updateUser,manager) values(UUID(),#{name},now(),now(),#{createUser},#{updateUser},#{manager})")
    Integer insert_hr_department(Department dep);
    //删除部门信息
    @Delete("delete from hr_department where id=#{id}")
    Integer delete_hr_department(Department dep);
    //更新部门信息
    @Update("update hr_department set name=#{name},manager=#{manager},updatetime=(now()),updateUser=#{updateUser} where id=#{id}")
    Integer update_hr_department(Department dep);
    //查询所有部门信息
    @Select("select id,name,manager from hr_department")
    List<Department> select_hr_department();
    //根据部门名称查询信息

}
