package cn.edu.tetcouponmanager.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 11:38 2019/12/28
 * @Modified By:
 */
@Component
public class CouponUtil {
    @Autowired
    private IdUtil idUtil;
    @Autowired
    Executor couponThreadPool;
    public CopyOnWriteArrayList<String> generateCode(String cMerchantId, int count) {
        //分组生成code
        CopyOnWriteArrayList<String> codes = new CopyOnWriteArrayList<>();
        int i = count / 2;
        CompletableFuture<Void> code1 = CompletableFuture.runAsync(() ->
        {
            for (int i1 = 0; i1 < i; i1++) {
                codes.add(idUtil.generateIdNoAsync(cMerchantId));
            }
        }, couponThreadPool);
        CompletableFuture<Void> code2 = CompletableFuture.runAsync(() ->
        {
            for (int i1 = 0; i1 < count - i; i1++) {
                codes.add(idUtil.generateIdNoAsync(cMerchantId));
            }
        }, couponThreadPool);
       CompletableFuture.allOf(code1, code2).join();
       return codes;
    }
}
