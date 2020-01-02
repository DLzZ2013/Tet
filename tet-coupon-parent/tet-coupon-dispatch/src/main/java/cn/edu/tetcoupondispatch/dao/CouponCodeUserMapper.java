package cn.edu.tetcoupondispatch.dao;

import cn.edu.tetcoupondispatch.entity.CouponCodeUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CouponCodeUserMapper {
    int deleteByPrimaryKey(String cCouponCode);

    int insert(CouponCodeUser record);

    int insertSelective(CouponCodeUser record);

    CouponCodeUser selectByPrimaryKey(String cCouponCode);

    int updateByPrimaryKeySelective(CouponCodeUser record);

    int updateByPrimaryKey(CouponCodeUser record);

    void insertRange(@Param("merchantId") String merchantId,@Param("cId") String id, @Param("codes") List<String> codes);

    int updateUserIdByMerchantIdAndCodeId(@Param("merchantId") String merchantId,@Param("code") String code,@Param("userId") String userId);
}