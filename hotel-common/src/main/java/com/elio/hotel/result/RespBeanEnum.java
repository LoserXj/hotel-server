package com.elio.hotel.result;

public enum RespBeanEnum {
    LOGIN_SUCCESS(200, "登陆成功"),

    LOGIN_ERROR_NOT_EXISTS_USER(201,"用户不存在"),
    LOGIN_ERROR_PASSWORD_ERROR(202,"密码错误"),

    REGISTER_ERROR(203,"该用户名已存在"),

    REGISTER_SUCCESS(204,"注册成功"),
    ;

    private RespBeanEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
