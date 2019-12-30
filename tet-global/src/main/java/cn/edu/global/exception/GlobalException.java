package cn.edu.global.exception;


import lombok.Getter;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 12:25 2019/11/14
 * @Modified By:
 */
@Getter
public class GlobalException extends RuntimeException {
    private String message;

    public GlobalException(String message)
    {
        this.message = message;
    }

}
