package com.qiancheng.charging.entity;

import java.sql.Date;

public class User {
    private String id; //用户id
    private String username; //用户名
    private String password; //密码
    private int role; //角色 0普通用户 1管理员
    private int flag;
    private String employeeId; //员工id
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;
    private Date lastLoginTime;
    private String name;
    public User() {

    }

    public User(String id, String username, String password, int role, int flag, String employeeId, Date createTime, Date updateTime, String createUser, String updateUser, Date lastLoginTime, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.flag = flag;
        this.employeeId = employeeId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.lastLoginTime = lastLoginTime;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
