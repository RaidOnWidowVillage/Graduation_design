package com.qiancheng.charging.login.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.login.entity.UserVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@MyBatisDao
public interface UserDao {
    @Insert("insert into hr_user(id,username,password,name,role,flag,employeeId,createtime,updatetime,createuser,updateuser,last_login_time) values(UUID(),#{username},#{password},#{name},1,1,#{employeeId},now(),now(),#{createUser},#{updateUser},now())")
    Integer insert_user(User user);

    @Insert("insert into hr_employee(id,name,gender,phone,email,address,departmentId,positionId,status,salaryId,createtime,updatetime,createuser,updateuser) " +
            "values(#{employeeId},#{name},1,'请输入电话','请输入邮件','请输入地址','请选择部门','请输入职位',1,'请选择薪资',now(),now(),#{createUser},#{updateUser})")
    Integer insert_employee(User user);

    @Select("SELECT id,username,password,name,role,flag,employeeId,createtime,updatetime,createuser,updateuser,last_login_time as lastLoginTime from hr_user where username = #{username}")
    User selectUserByUsername(User user);


    @Select("SELECT count(id) from hr_user where username = #{username}")
    Integer selectByUsername(User user);

    @Update("update hr_user set last_login_time=now() where id = #{id}")
    Integer updateLastLoginTime(String id);

    @Select("SELECT id,username,password,name,role,flag, employeeId from hr_user where (role=#{role} or role is null) and (username like '%${username}%' or username is null)")
    List<User> selectAllUser(User user);

    @Select("SELECT id,username,name,password,role,flag,employeeId from hr_user  where id=#{id}")
    User selectUserById(String id);

    @Update("update hr_user set username = #{username}, password = #{password}, role = #{role}, flag = #{flag} where id = #{id}")
    Integer updateUserById(User user);

    @Delete("delete from hr_user where id = #{id}")
    Integer deleteUserById(String id);

}
