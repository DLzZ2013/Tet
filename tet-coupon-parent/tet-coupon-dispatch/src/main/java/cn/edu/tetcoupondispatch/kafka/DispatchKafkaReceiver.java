package cn.edu.tetcoupondispatch.kafka;

import cn.edu.tetcouponcommon.Constants;
import cn.edu.tetcoupondispatch.service.CouponCodeUserService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 16:48 2019/12/30
 * @Modified By:
 */
@Component
public class DispatchKafkaReceiver {
    @Autowired
    private CouponCodeUserService couponCodeUserService;
    @KafkaListener(topics = {Constants.Coupon.Kafka.TOPIC_FOR_COUPON_CODE}, groupId = "test-consumer-group")
    public void listen(ConsumerRecord<String, String> record) throws IOException {
        String value = record.value();
        couponCodeUserService.generateCode(value);


    }
}
