package cn.edu.tetcouponmanager.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 11:36 2019/12/28
 * @Modified By:
 */
public class FutureUtil {
    public static String get(Future<String> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
