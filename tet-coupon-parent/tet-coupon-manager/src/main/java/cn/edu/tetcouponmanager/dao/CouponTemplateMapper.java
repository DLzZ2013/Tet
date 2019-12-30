package cn.edu.tetcouponmanager.dao;

import cn.edu.tetcouponmanager.entity.CouponTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CouponTemplate record);

    int insertSelective(CouponTemplate record);

    CouponTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CouponTemplate record);

    int updateByPrimaryKey(CouponTemplate record);
}