package cn.edu.tetcouponmanager.dao;

import cn.edu.tetcouponmanager.entity.CouponCodeUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface CouponCodeUserMapper {
    int deleteByPrimaryKey(String cCouponCode);

    int insert(CouponCodeUser record);

    int insertSelective(CouponCodeUser record);

    CouponCodeUser selectByPrimaryKey(String cCouponCode);

    int updateByPrimaryKeySelective(CouponCodeUser record);

    int updateByPrimaryKey(CouponCodeUser record);

    void insertRange(@Param("codes") List<CouponCodeUser> codes);
}