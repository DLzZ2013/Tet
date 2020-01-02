package cn.edu.tetcouponcommon;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 16:12 2019/12/30
 * @Modified By:
 */
public interface Constants{
    int DECR_VALUE = -1;

    interface Coupon
    {
        interface Kafka{
            String TOPIC_FOR_COUPON_CODE = "KAFKA_TOPIC_FOR_COUPON_CODE";
            String COUPON_ID ="KAFKA_COUPON_ID" ;
            String COUPON_COUNT ="KAFKA_COUPON_COUNT" ;
        }

        interface Redis{

            String COUPON_ID_BY_MERCHANT_ID ="REDIS_COUPON_ID_BY_MERCHANT_ID_";
            String COUPON_INFO_BY_COUPON_ID ="REDIS_COUPON_INFO_BY_COUPON_ID_" ;
            String COUPON_INFO ="REDIS_COUPON_INFO" ;
            String COUPON_COUNT ="REDIS_COUPON_COUNT" ;
            String COUPON_CODE_BY_COUPON_ID ="REDIS_COUPON_CODE_BY_COUPON_ID_" ;
            String COUPON_LEVEL ="_REDIS_COUPON_LEVEL_" ;
        }
    }
}
