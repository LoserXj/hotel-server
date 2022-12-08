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

    public static RespBean operation_success(){
        return new RespBean(RespBeanEnum.OPERATION_SUCCESS.getCode(), RespBeanEnum.OPERATION_SUCCESS.getMessage(), null);
    }

    public static RespBean operation_success(Object object){
        return new RespBean(RespBeanEnum.OPERATION_SUCCESS.getCode(), RespBeanEnum.OPERATION_SUCCESS.getMessage(), object);

    }

    public static RespBean operation_error(){
        return new RespBean(RespBeanEnum.OPERATION_ERROR.getCode(), RespBeanEnum.OPERATION_ERROR.getMessage(), null);

    }

    public static RespBean operation_error(Object object){
        return new RespBean(RespBeanEnum.OPERATION_ERROR.getCode(), RespBeanEnum.OPERATION_ERROR.getMessage(), object);

    }

    public static RespBean reserve_error(){
        return new RespBean(RespBeanEnum.RESERVE_ERROR.getCode(), RespBeanEnum.RESERVE_ERROR.getMessage(), null);

    }

    public static RespBean reserve_error(Object object){
        return new RespBean(RespBeanEnum.RESERVE_ERROR.getCode(), RespBeanEnum.RESERVE_ERROR.getMessage(), object);

    }

    public static RespBean reserve_success(){
        return new RespBean(RespBeanEnum.RESERVE_SUCCESS.getCode(), RespBeanEnum.RESERVE_SUCCESS.getMessage(), null);

    }

    public static RespBean reserve_success(Object object){
        return new RespBean(RespBeanEnum.RESERVE_SUCCESS.getCode(), RespBeanEnum.RESERVE_SUCCESS.getMessage(), object);

    }

    public static RespBean password_error(){
        return new RespBean(RespBeanEnum.PASSWORD_ERROR.getCode(), RespBeanEnum.PASSWORD_ERROR.getMessage(), null);

    }

    public static RespBean password_error(Object object){
        return new RespBean(RespBeanEnum.PASSWORD_ERROR.getCode(), RespBeanEnum.PASSWORD_ERROR.getMessage(), object);

    }

    public static RespBean password_success(){
        return new RespBean(RespBeanEnum.PASSWORD_SUCCESS.getCode(), RespBeanEnum.PASSWORD_SUCCESS.getMessage(), null);

    }

    public static RespBean password_success(Object object){
        return new RespBean(RespBeanEnum.PASSWORD_SUCCESS.getCode(), RespBeanEnum.PASSWORD_SUCCESS.getMessage(), object);

    }

    public static RespBean pay_error(){
        return new RespBean(RespBeanEnum.PAY_ERROR.getCode(), RespBeanEnum.PAY_ERROR.getMessage(), null);
    }

    public static RespBean pay_success(){
     return new RespBean(RespBeanEnum.PAY_SUCCESS.getCode(),RespBeanEnum.PAY_SUCCESS.getMessage(), null);
    }


    public static RespBean refund_error(){
        return new RespBean(RespBeanEnum.REFUND_ERROR.getCode(), RespBeanEnum.REFUND_ERROR.getMessage(), null);
    }

    public static RespBean refund_success(){
        return new RespBean(RespBeanEnum.REFUND_SUCCESS.getCode(),RespBeanEnum.REFUND_SUCCESS.getMessage(), null);
    }



}
