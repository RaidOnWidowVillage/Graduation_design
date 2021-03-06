package com.qiancheng.charging.attendance.dao;

import com.qiancheng.charging.attendance.entity.AttendanceBO;
import com.qiancheng.charging.common.MyBatisDao;
import com.qiancheng.charging.entity.Attendance;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@MyBatisDao
public interface AttendanceDao {

    @Select("select a.id,a.starttime,a.endtime,a.reason,a.type,a.flag,b.name from hr_attendance as a left join hr_user as b on a.user_id = b.id")
    List<AttendanceBO> getAllAttendance();

    @Update("update hr_attendance set flag = #{flag} where id = #{id}")
    Integer updateAttendance(Attendance attendance);

    @Delete("delete from hr_attendance where id = #{id}")
    Integer deleteAttendance(String id);

    @Update("update hr_attendance set starttime = #{startTime}, endtime = #{endTime},reason = #{reason} where id = #{id}")
    Integer updateAttendanceDate(Attendance attendance);

    @Insert("insert into hr_attendance(id,starttime,endtime,reason,type,flag,createtime,updatetime,createuser,updateuser,user_id) " +
            "values(UUID(),#{startTime},#{endTime},#{reason},1,1,now(),now(),#{createUser},#{updateUser},#{userId})")
    Integer insertAttendance(Attendance attendance);
}
