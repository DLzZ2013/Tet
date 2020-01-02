package cn.edu.tetcoupondispatch.service;

import cn.edu.global.common.ResultResponse;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 19:42 2019/12/30
 * @Modified By:
 */
public interface DispatchService
{
    ResultResponse<Object> dispatchCoupon(String merchantId, String userId, int level);
}
