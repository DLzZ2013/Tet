package cn.edu.test;

import org.aspectj.weaver.ast.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 12:10 2019/12/26
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class);
    }
}
