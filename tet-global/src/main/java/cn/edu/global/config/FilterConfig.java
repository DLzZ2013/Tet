package cn.edu.global.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;

//@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
//        Log2Filter log2Filter = new Log2Filter();
//        filterFilterRegistrationBean.setFilter(log2Filter);
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setOrder(3);
       // filterFilterRegistrationBean.setEnabled(true);

        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();

//        LogFilter logFilter = new LogFilter();
//        filterFilterRegistrationBean.setFilter(logFilter);
        filterFilterRegistrationBean.addUrlPatterns("/*");
       // filterFilterRegistrationBean.setEnabled(true);
        //注册多个filter 调整一下优先级
        filterFilterRegistrationBean.setOrder(4);

        return filterFilterRegistrationBean;
    }
}