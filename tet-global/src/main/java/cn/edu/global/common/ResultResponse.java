package cn.edu.global.common;

import lombok.Data;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 11:06 2019/11/12
 * @Modified By:
 */
@Data
public class ResultResponse<T> {
    private int code;
    private String message;
    private T data;


    public ResultResponse(int code) {
        this.code = code;
    }

    public ResultResponse(int code, String message) {
        this(code);
        this.message = message;
    }

    public ResultResponse(int code, String message, T data) {
        this(code, message);
        this.data = data;
    }


    public static ResultResponse<Object> success() {
        return new ResultResponse<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }


    public static <T> ResultResponse<Object> success(T data) {
        ResultResponse<Object> success = success();
        success.setData(data);
        return success;
    }

    public static <T> ResultResponse fail() {
        return new ResultResponse<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage());
    }

    public static <T> ResultResponse fail(ResultEnum resultEnum) {
        return new ResultResponse(resultEnum.getCode(), resultEnum.getMessage());
    }

    public static <T> ResultResponse fail(String message) {
        return new ResultResponse(ResultEnum.FAIL.getCode(), message);
    }

    public static <T> ResultResponse fail(ResultEnum resultEnum, T data) {
        ResultResponse fail = fail(resultEnum);
        fail.setData(data);
        return fail;
    }


    public boolean isSuccess() {
        return this.code == ResultEnum.SUCCESS.getCode();
    }
}
