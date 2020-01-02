package cn.edu.tetcoupondispatch.service;

import java.io.IOException;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 16:56 2019/12/30
 * @Modified By:
 */
public interface CouponCodeUserService {

    void generateCode(String value) throws IOException;

}
