package com.qiancheng.charging.entity;

import java.sql.Date;

public class Salary {
    private String id; //薪资id
    private String name; //薪资名称
    private int basicSalary; //基本工资
    private int safe; //保险
    private int fund; //公积金
    private int tax; //个人所得税
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;

    public Salary() {

    }

    public Salary(String id, String name, int basicSalary, int safe, int fund, int tax, Date createTime, Date updateTime, String createUser, String updateUser) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.safe = safe;
        this.fund = fund;
        this.tax = tax;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }

    public int getFund() {
        return fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
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
