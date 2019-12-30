package cn.edu.tetcouponmanager.service.impl;

import cn.edu.tetcouponmanager.dao.CouponCodeUserMapper;
import cn.edu.tetcouponmanager.entity.CouponCodeUser;
import cn.edu.tetcouponmanager.service.CouponCodeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 15:41 2019/12/28
 * @Modified By:
 */
@Service
public class CouponCodeUserServiceImpl implements CouponCodeUserService {
    @Autowired
    CouponCodeUserMapper couponCodeUserMapper;
    @Override
    public void insertRange(List<CouponCodeUser> codes) {
        couponCodeUserMapper.insertRange(codes);
    }
}
