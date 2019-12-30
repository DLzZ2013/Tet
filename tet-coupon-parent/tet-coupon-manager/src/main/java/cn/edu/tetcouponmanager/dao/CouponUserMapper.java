package cn.edu.tetcouponmanager.dao;

import cn.edu.tetcouponmanager.entity.CouponUser;
import cn.edu.tetcouponmanager.entity.CouponUserKey;

public interface CouponUserMapper {
    int deleteByPrimaryKey(CouponUserKey key);

    int insert(CouponUser record);

    int insertSelective(CouponUser record);

    CouponUser selectByPrimaryKey(CouponUserKey key);

    int updateByPrimaryKeySelective(CouponUser record);

    int updateByPrimaryKey(CouponUser record);
}