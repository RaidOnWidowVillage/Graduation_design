package com.qiancheng.charging.common;

/**
 * Created by Jayne
 * Data:2018/6/29
 * TIME:9:19
 */
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),//成功
    ERROR(1,"ERROR"), //错误
    NEED_LOGIN(10,"NEED_LOGIN"); //需要登陆


    private final int code;
    private final String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}