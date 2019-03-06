package com.qiancheng.charging.login.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.entity.Position;
import com.qiancheng.charging.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@MyBatisDao
public interface UserDao {
    @Insert("insert into hr_user(id,username,password,role,flag,positionId,createtime,updatetime,createuser,updateuser,last_login_time) values(UUID(),#{username},#{password},1,1,1,now(),now(),#{createUser},#{updateUser},now())")
    Integer insert_user(User user);

    @Select("SELECT id,username,password,role,flag,positionId,createtime,updatetime,createuser,updateuser,last_login_time as lastLoginTime from hr_user where username = #{username}")
    User selectUserByUsername(User user);

    @Update("update hr_user set last_login_time=now() where id = #{id}")
    Integer updateLastLoginTime(String id);

    @Select("SELECT a.id,a.username,a.password,a.role,a.flag,b.name as positionId from hr_user as a left join hr_position as b on a.positionId = b.id")
    List<User> selectAllUser();

    @Select("SELECT a.username,a.password,a.role,a.flag,b.name as positionId from hr_user as a left join hr_position as b on a.positionId = b.id where a.id=#{id}")
    User selectUserById(String id);

    @Update("update hr_user set username = #{username}, password = #{password}, role = #{role}, flag = #{flag}, positionId = #{positionId} where id = #{id}")
    Integer updateUserById(User user);
}
