package com.qiancheng.charging.department.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.department.entity.DepartmentBO;
import com.qiancheng.charging.entity.Department;
import org.apache.ibatis.annotations.*;
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
    @Select("select a.id,a.name,a.createtime as createTime,a.manager,b.counte from hr_department as a left join (select departmentId,count(id) as counte from hr_employee GROUP BY departmentId) as b  on a.id = b. departmentId ")
    List<DepartmentBO> select_hr_department();
    //根据部门名称查询信息
    @Select({"<script>select a.id,a.name,a.createtime as createTime,a.manager,b.counte from hr_department as a left join (select departmentId,count(id) as counte from hr_employee GROUP BY departmentId) as b  on a.id = b. departmentId<where>" +
            "<if test= \"name != '' and name!=null  \">" +
            "and a.name=#{name}</if>" +
            "<if test= \"manager != '' and manager!=null  \">" +
            "and a.manager=#{manager}</if>" +
            "</where></script>"})
    List<DepartmentBO> queryby_hr_department(Department dep);
}
