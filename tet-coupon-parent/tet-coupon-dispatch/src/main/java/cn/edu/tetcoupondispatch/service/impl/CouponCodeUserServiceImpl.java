package cn.edu.tetcoupondispatch.service.impl;

import cn.edu.global.util.RedisUtils;
import cn.edu.tetcouponcommon.Constants;
import cn.edu.tetcoupondispatch.dao.CouponCodeUserMapper;
import cn.edu.tetcoupondispatch.service.CouponCodeUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 16:59 2019/12/30
 * @Modified By:
 */
@Service
public class CouponCodeUserServiceImpl implements CouponCodeUserService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    CouponCodeUserMapper couponCodeUserMapper;
    @Override
    public void generateCode(String value) throws IOException {
        //反序列化数据
        HashMap<String,String> hashMap = objectMapper.readValue(value, HashMap.class);
        //获取商家id集合
        Set<String> strings = hashMap.keySet();
        //遍历
        for (String merchantId : strings) {
            //获取value,反序列化为模板信息
            String couponInfo = hashMap.get(merchantId);
             HashMap<String,String> info = objectMapper.readValue(couponInfo, HashMap.class);
            Set<String> couponId = info.keySet();
            for (String id : couponId) {
                String codesStr = info.get(id);
                List codes = objectMapper.readValue(codesStr, List.class);
                //若生成的code不为null,存入redis和mysql
                if(codes!=null&&codes.size()!=0)
                {
                    //存入redis
                    redisUtils.sset(Constants.Coupon.Redis.COUPON_CODE_BY_COUPON_ID + id, codes.toArray());
                    //存入mysql
                    couponCodeUserMapper.insertRange(merchantId, id, codes);
                }
            }
        }

    }


}
