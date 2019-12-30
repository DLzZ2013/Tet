package cn.edu.global.exception;

import cn.edu.global.common.Constants;
import cn.edu.global.common.ResultResponse;
import cn.edu.global.exception.GlobalException;
import cn.edu.global.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 12:27 2019/11/14
 * @Modified By:
 */

/**
 * 对controller进行增强
 * 增强的目的是为 处理异常
 * 捕获所有controller出现异常 然后处理
 */

@ControllerAdvice//会对controller进行增强
@ResponseBody
@Slf4j//注解是lombok提供的 并没有记录日志的功能 记录日志的功能是log4j提供
public class GlobalExceptionHandler {
    @Autowired
    private MailService mailService;
    //捕获异常
    @ExceptionHandler({Exception.class})
    public ResultResponse resolve(Exception e)
    {
        //出现异常 需要打印日志 为了改bug
        log.error("项目出现突发异常了~："+e);
        //根据这个异常返回给前台提示信息
        //发送邮件
        mailService.sendHtmlMail("Tet系统异常",e.toString(), new String[]{Constants.Private.MAIL});
        ResultResponse fail = ResultResponse.fail();
        //设置真正异常信息
        fail.setMessage(e.getMessage());
        return fail;
    }
    //捕获异常
    @ExceptionHandler({GlobalException.class})
    public ResultResponse resolve(GlobalException e)
    {
        //出现异常 需要打印日志 为了给我们看
        log.error("项目出现突发异常了~："+e.getMessage());
        //根据这个异常返回给前台提示信息
        ResultResponse fail = ResultResponse.fail();
        fail.setMessage(e.getMessage());
        return fail;
    }
}
