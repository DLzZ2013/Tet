package cn.edu.zuul.filter;

import cn.edu.global.kafka.KafkaSender;
import cn.edu.global.util.RedisUtils;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:17 2019/12/26
 * @Modified By:
 */
@Component
@Slf4j
public class LoginFilter extends AbstractPreZuulFilter {
    @Override
    public int filterOrder() {
        return 2;
    }
    @Value("${name}")
    private String name;
    @Autowired
    private KafkaSender kafkaSender;
    @Autowired
    private RedisUtils redisUtils;
    @Override
    public Object run() throws ZuulException {
        if (requestContext.getBoolean(NEXT)) {
            log.info("{}登录成功",name);
            log.info("获取kafka对象：{}",kafkaSender);
            log.info("获取redis集群的key：{}",redisUtils.getAndSet("dlzz2013","dlz"));
            kafkaSender.sendMessage("hellokafka","kafka消息发送成功");
            return success();
        }
        return fail(701, "登录失败");
    }
}
