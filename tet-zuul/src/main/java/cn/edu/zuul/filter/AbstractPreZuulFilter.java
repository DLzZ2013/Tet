package cn.edu.zuul.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:15 2019/12/26
 * @Modified By:
 */
@Component
public abstract class AbstractPreZuulFilter extends AbstractAuulFilter {
    @Override
    public String filterType() {
        //设置为前置过滤器
        return FilterConstants.PRE_TYPE;
    }
}
