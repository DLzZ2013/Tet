package cn.edu.zuul.filter;

import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:33 2019/12/26
 * @Modified By:
 */
@Component
@Slf4j
public class AccessLogFilter extends AbstractPostFilter {
    @Override
    public int filterOrder() {
        //设置为倒数第二个过滤器
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }

    @Override
    public Object run() throws ZuulException {
        //打印日志
        long startTime = (long) requestContext.get("startTime");
        log.info("{}:当前请求的时间为{}",requestContext.getRequest().getRequestURL(),System.currentTimeMillis()-startTime);
        return success();
    }
}
