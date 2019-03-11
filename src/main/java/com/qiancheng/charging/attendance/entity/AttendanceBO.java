package com.qiancheng.charging.attendance.entity;

import java.sql.Date;

public class AttendanceBO {
    private String id;   //考勤ID
    private String userId; // 用户Id
    private String name;
    private Date startTime; //开始时间
    private Date endTime; //结束时间
    private String reason; //原因
    private int type; //类型
    private int flag; //0待核实，1通过，2未通过
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;

    public AttendanceBO() {
    }

    public AttendanceBO(String id, String userId, String name, Date startTime, Date endTime, String reason, int type, int flag, Date createTime, Date updateTime, String createUser, String updateUser) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.type = type;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
