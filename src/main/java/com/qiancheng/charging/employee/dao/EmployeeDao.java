package com.qiancheng.charging.employee.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.employee.entity.EmployeeBO;
import com.qiancheng.charging.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@MyBatisDao
public interface EmployeeDao {
    @Insert("insert into hr_employee(id,name,gender,phone,email,address,departmentId,positionId,status,salaryId,createtime,updatetime,createuser,updateuser,contact) " +
            "values(UUID(),#{name},#{gender},#{phone},#{email},#{address},#{departmentId},#{position},#{status},#{salaryId},now(),now(),#{createUser},#{updateUser},#{contact})")
    int add_Employee(Employee employee);

    @Delete("delete from hr_employee where id = #{id}")
    int del_Employee(Employee employee);

    @Update("update hr_employee SET name = #{name},gender = #{gender},phone = #{phone},email = #{email},address = #{address},departmentId = #{departmentId},status = #{status},salaryId = #{salaryId},updatetime =now(),updateuser = #{updateUser}" +
            "WHERE id = #{id}")
    int update_Employee(Employee employee);

    @Select("<script>"
           + "SELECT a.id,a.name,a.gender,a.phone,a.email,a.address,a.status,a.contact,"
           + "b.name as 'department.name',b.id as 'department.id',"
           + "c.name as 'salary.name', c.basicsalary as 'salary.basicSalary',c.safe as 'salary.safe',c.fund as 'salary.fund',c.tax as 'salary.tax'"
           + "FROM hr_employee as a LEFT JOIN hr_department as b on a.departmentId = b.id "
           + " LEFT JOIN hr_salary as c on a.salaryId = c.id "
           + "<where>"
           + "<if test='gender!=0'>"
           + "     a.gender=#{gender}"
           + "</if>"
           + "<if test= \"name != '' and name!=null  \">"
           + "    and a.name like '%${name}%'"
           + "</if>"
           + "<if test=\" departmentId != '' and departmentId!=null  \">"
           + "    and a.departmentId =#{departmentId}"
           + "</if>"
           + "<if test='status!=0'>"
           + "    and a.status =#{status}"
           + "</if></where></script>")
    List<EmployeeBO> select_All_Employee(Employee employee);

    @Select("SELECT a.id,a.name,a.gender,a.phone,a.email,a.address,a.status,a.contact,\n" +
            "b.name as 'department.name',\n" +
            "b.id as 'department.id',\n" +
            "c.name as 'salary.name' ,\n" +
            "c.basicsalary as 'salary.basicSalary',\n" +
            "c.safe as 'salary.safe',\n" +
            "c.fund as 'salary.fund',\n" +
            "c.tax as 'salary.tax'\n" +
            "\n" +
            "FROM hr_employee as a LEFT JOIN hr_department as b on a.departmentId = b.id\n" +
            "LEFT JOIN hr_salary as c on a.salaryId = c.id where a.id = #{id}")
    EmployeeBO select_One_Employee(String id);
}
