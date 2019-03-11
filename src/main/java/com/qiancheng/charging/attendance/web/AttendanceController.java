package com.qiancheng.charging.attendance.web;

import com.qiancheng.charging.attendance.service.AttendanceService;
import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value="/select_attendance" , method = {RequestMethod.GET})
    @ResponseBody
    public ServerResponse getAllAttendance(){
        return attendanceService.getAllAttendance();
    }


    @RequestMapping(value="/update_attendance" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse UpdateAttendance(Attendance attendance){
        return attendanceService.updateAttendance(attendance);
    }

    @RequestMapping(value="/delete_attendance" , method = {RequestMethod.GET})
    @ResponseBody
    public ServerResponse DeleteAttendance(String id){
        return attendanceService.deleteAttendance(id);
    }
}
