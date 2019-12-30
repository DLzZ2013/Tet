package cn.edu.global.common;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 9:57 2019/11/13
 * @Modified By:
 */
public enum ResultEnum {

    SUCCESS(601,"请求成功"),
    FAIL(701,"请求失败"),
    ACCOUNT_FAIL(702, "用户名不存在"),
    PWD_FAIL(703, "密码错误"),
    USERNAME_REPEAT(704,"用户名重复"),
    TEL_REPEAT(705,"电话号码重复"),
    MAIL_REPEAT(706, "邮箱地址重复"),
    REMARK_REPEAT(707, "描述重复"),
    CHECKED(708,"参数正确");

    ResultEnum(int code, String message)
    {
        this.code = code;
        this.message = message;
    }


    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
