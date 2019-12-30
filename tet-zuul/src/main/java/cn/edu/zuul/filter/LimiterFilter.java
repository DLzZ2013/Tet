package cn.edu.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:21 2019/12/26
 * @Modified By:
 */
@Component
@Slf4j
public class LimiterFilter extends AbstractPreZuulFilter {
    //令牌桶(限流器)
    //没秒限制10次访问
    private RateLimiter limiter = RateLimiter.create(10);

    //限流10次
    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public Object run() throws ZuulException {
        if (limiter.tryAcquire()) {
            log.info("{}通过令牌桶拿到令牌", requestContext.getRequest().getRequestURL());
            //设置请求时间,以便最后打印日志
            requestContext.set("startTime",System.currentTimeMillis());
            return success();
        }
        log.info("{}拿不到到令牌", requestContext.getRequest().getRequestURL());
        return fail(701, "网络开小差~");
    }
}
