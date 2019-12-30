package cn.edu.zuul.filter;

import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:31 2019/12/26
 * @Modified By:
 */
@Component
public abstract class AbstractPostFilter extends AbstractAuulFilter {
    @Override
    public String filterType() {
        //设置为后置过滤器
        return FilterConstants.POST_TYPE;
    }

}
