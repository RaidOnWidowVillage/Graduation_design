package com.qiancheng.charging.attendance.web;

import com.qiancheng.charging.attendance.service.AttendanceService;
import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Attendance;
import com.qiancheng.charging.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value="/update_attendance_date" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse UpdateAttendanceDate(Attendance attendance){
        return attendanceService.updateAttendanceDate(attendance);
    }

    @RequestMapping(value="/insert_attendance" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse InsertAttendance(HttpServletRequest request, Attendance attendance){

        HttpSession session = request.getSession();
        User res = (User)session.getAttribute("userMsg");

        if(res!=null){
            attendance.setCreateUser(res.getCreateUser());
            attendance.setUpdateUser(res.getUpdateUser());
            attendance.setUserId(res.getId());
            return attendanceService.insertAttendance(attendance);
        }else{
            return ServerResponse.createByErrorMessage("请先登陆");
        }

    }

}
