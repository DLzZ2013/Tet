package cn.edu.tetcouponmanager.service.impl;

import cn.edu.global.kafka.KafkaSender;
import cn.edu.global.util.RedisUtils;
import cn.edu.tetcouponcommon.Constants;
import cn.edu.tetcouponmanager.dao.CouponTemplateMapper;
import cn.edu.tetcouponmanager.entity.CouponTemplate;
import cn.edu.tetcouponmanager.entity.param.CouponTemplateParam;
import cn.edu.tetcouponmanager.service.CouponTemplateService;
import cn.edu.tetcouponmanager.utils.CouponUtil;
import cn.edu.tetcouponmanager.utils.FutureUtil;
import cn.edu.tetcouponmanager.utils.IdUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:21 2019/12/28
 * @Modified By:
 */
@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {
    @Autowired
    private CouponTemplateMapper couponTemplateMapper;
    @Autowired
    private IdUtil idUtil;
    @Autowired
    private CouponUtil couponUtil;
    @Autowired
    Executor couponThreadPool;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    KafkaSender kafkaSender;
    @Override
    @Transactional
    public void insert(CouponTemplateParam couponTemplateParam) {
        //构造插入对象
        CouponTemplate build = CouponTemplate.builder().cAmount(new BigDecimal(String.valueOf(couponTemplateParam.getCAmount())))
                .cAmountLimit(new BigDecimal(String.valueOf(couponTemplateParam.getCAmountLimit())))
                .cCategory(couponTemplateParam.getCCategory())
                .cConsumeStatus(couponTemplateParam.getCConsumeStatus())
                .cCount(couponTemplateParam.getCCount())
                .cDesc(couponTemplateParam.getCDesc())
                .cExpireType(couponTemplateParam.getCExpireType())
                .cExpireDay(couponTemplateParam.getCExpireDay())
                .cProductLine(couponTemplateParam.getCProductLine())
                .cMerchantId(couponTemplateParam.getCMerchantId())
                .cAreaId(couponTemplateParam.getCMerchantId())
                .cMerchantName(couponTemplateParam.getCMerchantName()).build();
        //生成唯一id
        build.setcId(FutureUtil.get(idUtil.generateId(couponTemplateParam.getCMerchantId())));
        //Todo log url
        couponTemplateMapper.insertSelective(build);
        //判断level
        int level = build.getCAmount().compareTo(new BigDecimal(50)) > 0 ? 1 : 0;
        try {
            //将商铺优惠券模板存入到redis
            redisUtils.sset(Constants.Coupon.Redis.COUPON_ID_BY_MERCHANT_ID+build.getcMerchantId()+Constants.Coupon.Redis.COUPON_LEVEL+level,build.getcId());
            //redis存储优惠券模板信息
            //剩余数量（实时变化）
            redisUtils.hset(Constants.Coupon.Redis.COUPON_INFO_BY_COUPON_ID + build.getcId(),
                    Constants.Coupon.Redis.COUPON_COUNT,String.valueOf(build.getcCount()));
            //其他信息
            String info = objectMapper.writeValueAsString(build);
            redisUtils.hset(Constants.Coupon.Redis.COUPON_INFO_BY_COUPON_ID + build.getcId(),
                    Constants.Coupon.Redis.COUPON_INFO, info);

            //通知dispatch模块分发优惠券
            //序列化数据
            HashMap<String, String> couponByMerchantId = Maps.newHashMap();
            //将模板id和code发送
            HashMap<String,String> couponInfo = Maps.newHashMap();
            CopyOnWriteArrayList<String> codes = couponUtil.generateCode(build.getcMerchantId(), build.getcCount());
            String str = objectMapper.writeValueAsString(codes);
            couponInfo.put(build.getcId(),str);
            //序列化
            couponByMerchantId.put(build.getcMerchantId(),objectMapper.writeValueAsString(couponInfo));
            kafkaSender.sendMessage(Constants.Coupon.Kafka.TOPIC_FOR_COUPON_CODE,objectMapper.writeValueAsString(couponByMerchantId));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        //生成code
//        CopyOnWriteArrayList<CouponCodeUser> codes = couponUtil.generateCode(couponTemplateParam.getCMerchantId(), couponTemplateParam.getCCount());
//        List<CouponCodeUser> collect = codes.stream().map(code ->
//        {
//            code.setcId(build.getcId());
//            code.setcStatus("1");
//            return code;
//        }).collect(Collectors.toList());
//        //插入数据库
//        couponCodeUserService.insertRange(collect);
    }
}
