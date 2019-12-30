package cn.edu.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 9:43 2019/12/26
 * @Modified By:
 */
@Component
@Slf4j
public abstract class AbstractAuulFilter extends ZuulFilter {
     static final String NEXT = "next";
     RequestContext requestContext;

    //shouldFilter方法完成与过滤主逻辑不想关的过滤，如限流任务，认证请求
    //返回false不进入run方法，直接进入过滤器链，否则进入
    //run方法完成过滤主逻辑
    //实现解耦合
    @Override
    public boolean shouldFilter() {
        //1.初始化
        requestContext =RequestContext.getCurrentContext();
        //2.通过标识来判断是否通过
        //第一次获取为null，所以返回true，
        //如果false，告诉剩下的should方法不通过
        return  requestContext.getBoolean(NEXT,true);
    }

    /**
     * run方法失败后调用的方法
     *
     * @param code
     * @param message
     */
    Object fail(int code, String message) {
        //1.首先设置flag为false
        requestContext.set(NEXT,false);
        //2.获取请求,打印日志
        HttpServletRequest request = requestContext.getRequest();
        log.info("当前请求失败：{}，url：{}",this.getClass().getName(),request.getRequestURI());
        //3.请求以及失败，终止zuul
        requestContext.setSendZuulResponse(false);
        //4.zuul不去请求微服务后就拿不到返回值
        //自定义返回值
            //a.定义返回code
            requestContext.setResponseStatusCode(code);
            //b.定义返回信息
            requestContext.setResponseBody(message);
            //c.定义返回类型
            requestContext.getResponse().setContentType("application/json;charset=utf-8");
         //5.返回null
         return null;
    }

    /**
     * run方法执行成功后调用
     */
    Object success()
    {
        //1.设置flag为true
        requestContext.set(NEXT,true);
        log.info("{} run方法执行成功",this.getClass().getName());
        return null;
    }
}
