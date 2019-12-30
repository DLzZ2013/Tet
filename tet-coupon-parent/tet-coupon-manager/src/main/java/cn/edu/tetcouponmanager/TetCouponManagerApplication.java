package cn.edu.tetcouponmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 20:26 2019/12/26
 * @Modified By:
 */
@SpringBootApplication
@EnableSwagger2
@EnableAsync
@MapperScan("cn.edu.tetcouponmanager.dao")
@ComponentScan({"cn.edu.tetcouponmanager","cn.edu.global"})
public class TetCouponManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TetCouponManagerApplication.class);
    }
}
