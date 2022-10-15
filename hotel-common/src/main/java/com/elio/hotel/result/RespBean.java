package com.elio.hotel.result;



import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RespBean {
    private Integer code;
    private String message;
    private Object object;

    public RespBean(Integer code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }
    public static RespBean login_success() {
        return new RespBean(RespBeanEnum.LOGIN_SUCCESS.getCode(), RespBeanEnum.LOGIN_SUCCESS.getMessage(), null);
    }

    public static RespBean login_success(Object object) {
        return new RespBean(RespBeanEnum.LOGIN_SUCCESS.getCode(), RespBeanEnum.LOGIN_SUCCESS.getMessage(), object);
    }

    public static RespBean login_error_not_exists_user(){
        return new RespBean(RespBeanEnum.LOGIN_ERROR_NOT_EXISTS_USER.getCode(), RespBeanEnum.LOGIN_ERROR_NOT_EXISTS_USER.getMessage(), null);
    }
    public static RespBean login_error_not_exists_user(Object object){
        return new RespBean(RespBeanEnum.LOGIN_ERROR_NOT_EXISTS_USER.getCode(), RespBeanEnum.LOGIN_ERROR_NOT_EXISTS_USER.getMessage(), object);
    }

    public static RespBean login_error_password(){
        return new RespBean(RespBeanEnum.LOGIN_ERROR_PASSWORD_ERROR.getCode(),RespBeanEnum.LOGIN_ERROR_PASSWORD_ERROR.getMessage(),null);
    }
    public static RespBean login_error_password(Object object){
        return new RespBean(RespBeanEnum.LOGIN_ERROR_PASSWORD_ERROR.getCode(),RespBeanEnum.LOGIN_ERROR_PASSWORD_ERROR.getMessage(),object);
    }
    public static RespBean register_error(){
        return new RespBean(RespBeanEnum.REGISTER_ERROR.getCode(), RespBeanEnum.REGISTER_ERROR.getMessage(), null);
    }

    public static RespBean register_error(Object object){
        return new RespBean(RespBeanEnum.REGISTER_ERROR.getCode(), RespBeanEnum.REGISTER_ERROR.getMessage(), object);
    }

    public static RespBean register_success(){
        return new RespBean(RespBeanEnum.REGISTER_SUCCESS.getCode(), RespBeanEnum.REGISTER_SUCCESS.getMessage(),null );
    }

    public static RespBean register_success(Object object){
        return new RespBean(RespBeanEnum.REGISTER_SUCCESS.getCode(), RespBeanEnum.REGISTER_SUCCESS.getMessage(),object );
    }


}
