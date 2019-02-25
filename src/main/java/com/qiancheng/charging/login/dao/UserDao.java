package com.qiancheng.charging.login.dao;

import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.entity.User;
import org.apache.ibatis.annotations.Insert;

@MyBatisDao
public interface UserDao {
    @Insert("insert into hr_position(id,name) values(UUID(),#{name})")
    Integer insert_hr_position(User user);
}
