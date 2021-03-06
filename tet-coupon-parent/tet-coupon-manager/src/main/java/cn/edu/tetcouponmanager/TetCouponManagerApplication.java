package cn.edu.tetcouponmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 20:26 2019/12/26
 * @Modified By:
 */
//@SpringBootApplication
@EnableSwagger2
@EnableAsync
//@EnableDiscoveryClient
@SpringCloudApplication
@EnableFeignClients
//@EnableCircuitBreaker//开启hystrix
@MapperScan("cn.edu.tetcouponmanager.dao")
@ComponentScan({"cn.edu.tetcouponmanager","cn.edu.global"})
public class TetCouponManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TetCouponManagerApplication.class);
    }
}
