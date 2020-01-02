package cn.edu.tetcouponmanager.controller;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 15:45 2019/12/31
 * @Modified By:
 */
@FeignClient("TET-COUPON-DISPATCH")
public interface RestTemplateControllerApi {
    @GetMapping("restTemplate")
    String restTemplate();
}
