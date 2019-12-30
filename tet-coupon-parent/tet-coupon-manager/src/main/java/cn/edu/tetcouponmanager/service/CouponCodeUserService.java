package cn.edu.tetcouponmanager.service;

import cn.edu.tetcouponmanager.entity.CouponCodeUser;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 15:40 2019/12/28
 * @Modified By:
 */
public interface CouponCodeUserService {

    void insertRange(List<CouponCodeUser> codes);
}
