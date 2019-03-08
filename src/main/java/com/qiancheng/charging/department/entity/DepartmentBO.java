package com.qiancheng.charging.department.entity;


import java.sql.Date;

public class DepartmentBO {
    private String id; //部门id
    private String name; //部门名称
    private Date createTime;
    private String manager;
    private String counte;


    public DepartmentBO() {
    }

    public DepartmentBO(String id, String name, Date createTime, String manager, String counte) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.manager = manager;
        this.counte = counte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getCounte() {
        return counte;
    }

    public void setCounte(String counte) {
        this.counte = counte;
    }
}
