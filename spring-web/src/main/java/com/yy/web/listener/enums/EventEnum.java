package com.yy.web.listener.enums;


public enum EventEnum {

    USER_REGISTER_MAIL(1,"用户注册发送邮件");

    private int code;

    private String desc;

    EventEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
