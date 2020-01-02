package cn.edu.tetcoupondispatch.service.impl;

import cn.edu.global.common.ResultResponse;
import cn.edu.global.util.RedisUtils;
import cn.edu.tetcouponcommon.Constants;
import cn.edu.tetcoupondispatch.dao.CouponCodeUserMapper;
import cn.edu.tetcoupondispatch.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 19:42 2019/12/30
 * @Modified By:
 */
public class DispatchServiceImpl implements DispatchService {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private CouponCodeUserMapper couponCodeUserMapper;
    @Override
    public ResultResponse dispatchCoupon(String merchantId, String userId, int level) {
        //redis pop code
        //get cid by merchantId
        String cId = (String)redisUtils.sRandom(Constants.Coupon.Redis.COUPON_ID_BY_MERCHANT_ID + merchantId + Constants.Coupon.Redis.COUPON_LEVEL + level);
        if (cId!=null) {
            String code = (String) redisUtils.spop(Constants.Coupon.Redis.COUPON_CODE_BY_COUPON_ID + cId);
            //update redis and mysql
            if (code != null) {
                try {
                    //update redis count
//                redisUtils.hincr(Constants.Coupon.Redis.COUPON_INFO_BY_COUPON_ID + cId, Constants.Coupon.Redis.COUPON_COUNT, Constants.DECR_VALUE);
                    //update userId
                    int lines = couponCodeUserMapper.updateUserIdByMerchantIdAndCodeId(merchantId, code, userId);
                    if (lines<1)
                    {
                        //rollback
                        redisUtils.sset(Constants.Coupon.Redis.COUPON_CODE_BY_COUPON_ID + cId, code);
                    }
                } catch (Exception e) {
                    //rollback
                    redisUtils.sset(Constants.Coupon.Redis.COUPON_CODE_BY_COUPON_ID + cId, code);
                    throw new RuntimeException();
                }
            }
        }
        return ResultResponse.success();
    }
}
