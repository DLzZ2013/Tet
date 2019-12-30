package cn.edu.tetcouponmanager.controller.util;

import cn.edu.global.exception.GlobalException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 14:16 2019/11/14
 * @Modified By:
 */
public class BindingResultUtil {

    /**
     * 检查校验结果
     * @param bindingResult
     */
    public static void checkResult(BindingResult bindingResult) {
        //1、判断是否有验h证错误
        if (bindingResult.hasErrors())
        {
            //2、获取验证信息
            StringBuilder sb = new StringBuilder("数据验证失败：");
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error:allErrors
                 ) {
                FieldError fieldError = (FieldError)error;
                sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage());
            }
            //3、抛出自定义异常
            throw new GlobalException(sb.toString());
        }
    }
}
