package cn.edu.tetcoupondispatch.controller;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:42 2019/12/31
 * @Modified By:
 */
@RestController
@Slf4j
public class RestTemplateController {
    int i =0;
    @GetMapping("restTemplate")
    public String restTemplate() throws InterruptedException {
        if (i++>1)
        {
            Thread.sleep(2000);
        }
        log.info("dispatch接收到服务调用:{}",i);
        return "dispatch发送的消息";
    }
}
