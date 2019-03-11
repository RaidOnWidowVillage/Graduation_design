package com.qiancheng.charging.attendance.service;

import com.qiancheng.charging.attendance.entity.AttendanceBO;
import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    ServerResponse<List<AttendanceBO>> getAllAttendance();

    ServerResponse updateAttendance(Attendance attendance);

    ServerResponse deleteAttendance(String id);
}
