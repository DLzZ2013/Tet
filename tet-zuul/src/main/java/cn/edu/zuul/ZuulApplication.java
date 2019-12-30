package cn.edu.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 16:33 2019/12/25
 * @Modified By:
 */
@SpringBootApplication
//标注为客户端
@EnableDiscoveryClient
//开启zuul
@EnableZuulProxy
@ComponentScan({"cn.edu.zuul","cn.edu.global"})
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
