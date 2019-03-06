package com.qiancheng.charging.login.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.entity.Position;
import com.qiancheng.charging.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@MyBatisDao
public interface UserDao {
    @Insert("insert into hr_user(id,username,password,role,flag,positionId,createtime,updatetime,createuser,updateuser,last_login_time) values(UUID(),#{username},#{password},1,1,1,now(),now(),#{createUser},#{updateUser},now())")
    Integer insert_user(User user);

    @Select("SELECT id,username,password,role,flag,positionId,createtime,updatetime,createuser,updateuser,last_login_time as lastLoginTime from hr_user where username = #{username}")
    User selectUserByUsername(User user);

    @Update("update hr_user set last_login_time=now()")
    Integer updateLastLoginTime();
}
