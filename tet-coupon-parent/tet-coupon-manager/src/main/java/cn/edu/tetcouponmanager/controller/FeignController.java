package cn.edu.tetcouponmanager.controller;

import cn.edu.global.common.ResultResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 22:47 2020/1/1
 * @Modified By:
 */
@RestController
@Slf4j
public class FeignController {
    @Autowired
    private RestTemplateControllerApi restTemplateControllerApi;

    @GetMapping("hystrixTest")
    @HystrixCommand(fallbackMethod = "fallback")
    public ResultResponse restTemplate() {
        log.info("hystrixTest");
        String str = restTemplateControllerApi.restTemplate();
        log.info("FeignController.restTemplate:{}", str);
        return ResultResponse.success();
    }

    //与被降级的方法参数跟返回值必须相同
    public ResultResponse fallback() {
        log.info("FeignController.fallback");
        return ResultResponse.success();
    }
}
