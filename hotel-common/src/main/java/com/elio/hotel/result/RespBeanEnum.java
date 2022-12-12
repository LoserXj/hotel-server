package com.elio.hotel.result;

public enum RespBeanEnum {
    LOGIN_SUCCESS(200, "登陆成功"),

    LOGIN_ERROR_NOT_EXISTS_USER(201,"用户不存在"),
    LOGIN_ERROR_PASSWORD_ERROR(202,"密码错误"),

    REGISTER_ERROR(203,"该用户名已存在"),

    REGISTER_SUCCESS(204,"注册成功"),

    OPERATION_SUCCESS(205,"操作成功"),
    OPERATION_ERROR(206,"操作失败"),

    RESERVE_SUCCESS(207,"预定成功"),
    RESERVE_ERROR(208,"预定失败，原因可能是这个房间已经被别人给预定了"),

    PASSWORD_ERROR(209,"密码错误，请重新输入密码"),
    PASSWORD_SUCCESS(210,"密码正确"),

    PAY_ERROR(211,"支付失败"),
    PAY_SUCCESS(212,"支付成功"),
    REFUND_SUCCESS(213,"退款成功"),
    REFUND_ERROR(214,"申请成功,请耐心等待"),
    SECKILL_SUCCESS(215,"抢购成功"),
    SECKILL_FAIL(216,"抢购失败"),
    SECKILL_BUSY(217,"系统繁忙"),
    POINT_SUCCESS(218,"兑换成功"),
    POINT_ERROR(219,"积分不足")

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
