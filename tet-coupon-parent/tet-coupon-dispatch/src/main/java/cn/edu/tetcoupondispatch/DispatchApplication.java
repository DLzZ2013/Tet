package cn.edu.tetcoupondispatch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 16:50 2019/12/30
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient

@MapperScan("cn.edu.tetcoupondispatch.dao")
@ComponentScan({"cn.edu.tetcoupondispatch","cn.edu.global"})
public class DispatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(DispatchApplication.class);
    }
}
