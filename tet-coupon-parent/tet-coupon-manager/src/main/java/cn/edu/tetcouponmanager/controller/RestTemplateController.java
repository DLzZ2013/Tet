package cn.edu.tetcouponmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 14:14 2019/12/31
 * @Modified By:
 */
@RestController
@Slf4j
public class RestTemplateController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RestTemplateControllerApi templateControllerApi;
    @GetMapping("restTemplate")
    public String restTemplate()
    {
        log.info("manager远程调用dispatch");
        String str = templateControllerApi.restTemplate();
//        String str = restTemplate.getForObject("http://TET-COUPON-DISPATCH/restTemplate", String.class);
        log.info("manager远程调用dispatch成功：{}",str);
        return str;
    }
}
