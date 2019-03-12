package com.qiancheng.charging.attendance.service.impl;

import com.qiancheng.charging.attendance.dao.AttendanceDao;
import com.qiancheng.charging.attendance.entity.AttendanceBO;
import com.qiancheng.charging.attendance.service.AttendanceService;
import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public ServerResponse<List<AttendanceBO>> getAllAttendance() {
        List<AttendanceBO> result = attendanceDao.getAllAttendance();

        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse updateAttendance(Attendance attendance) {
        Integer result = attendanceDao.updateAttendance(attendance);
        //如果增加一条成功，返回1
        if(result>0){
            return ServerResponse.createBySuccess("更新成功");
        }else{
            return ServerResponse.createByErrorMessage("更新失败");
        }
    }

    @Override
    public ServerResponse deleteAttendance(String id) {
        Integer result = attendanceDao.deleteAttendance(id);
        //如果增加一条成功，返回1
        if(result>0){
            return ServerResponse.createBySuccess("删除成功");
        }else{
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    @Override
    public ServerResponse updateAttendanceDate(Attendance attendance) {
        Integer result = attendanceDao.updateAttendanceDate(attendance);
        //如果增加一条成功，返回1
        if(result>0){
            return ServerResponse.createBySuccess("更新成功");
        }else{
            return ServerResponse.createByErrorMessage("更新失败");
        }
    }

    @Override
    public ServerResponse insertAttendance(Attendance attendance) {
        Integer result = attendanceDao.insertAttendance(attendance);
        //如果增加一条成功，返回1
        if(result>0){
            return ServerResponse.createBySuccess("新增成功");
        }else{
            return ServerResponse.createByErrorMessage("新增失败");
        }
    }
}
