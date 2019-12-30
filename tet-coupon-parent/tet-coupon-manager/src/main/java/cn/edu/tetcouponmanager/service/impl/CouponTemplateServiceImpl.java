package cn.edu.tetcouponmanager.service.impl;

import cn.edu.tetcouponmanager.dao.CouponCodeUserMapper;
import cn.edu.tetcouponmanager.dao.CouponTemplateMapper;
import cn.edu.tetcouponmanager.entity.CouponCodeUser;
import cn.edu.tetcouponmanager.entity.CouponTemplate;
import cn.edu.tetcouponmanager.entity.param.CouponTemplateParam;
import cn.edu.tetcouponmanager.service.CouponCodeUserService;
import cn.edu.tetcouponmanager.service.CouponTemplateService;
import cn.edu.tetcouponmanager.utils.CouponUtil;
import cn.edu.tetcouponmanager.utils.FutureUtil;
import cn.edu.tetcouponmanager.utils.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:21 2019/12/28
 * @Modified By:
 */
@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {
    @Autowired
    private CouponTemplateMapper couponTemplateMapper;
    @Autowired
    private CouponCodeUserService couponCodeUserService;
    @Autowired
    private IdUtil idUtil;
    @Autowired
    private CouponUtil couponUtil;
    @Autowired
    Executor couponThreadPool;
    @Override
    @Transactional
    public void insert(CouponTemplateParam couponTemplateParam) {
        //构造插入对象
        CouponTemplate build = CouponTemplate.builder().cAmount(new BigDecimal(String.valueOf(couponTemplateParam.getCAmount())))
                .cAmountLimit(new BigDecimal(String.valueOf(couponTemplateParam.getCAmountLimit())))
                .cCategory(couponTemplateParam.getCCategory())
                .cConsumeStatus(couponTemplateParam.getCConsumeStatus())
                .cCount(couponTemplateParam.getCCount())
                .cDesc(couponTemplateParam.getCDesc())
                .cExpireType(couponTemplateParam.getCExpireType())
                .cExpireDay(couponTemplateParam.getCExpireDay())
                .cProductLine(couponTemplateParam.getCProductLine())
                .cMerchantId(couponTemplateParam.getCMerchantId())
                .cAreaId(couponTemplateParam.getCMerchantId())
                .cMerchantName(couponTemplateParam.getCMerchantName()).build();
        //生成唯一id
        build.setcId(FutureUtil.get(idUtil.generateId(couponTemplateParam.getCMerchantId())));
        //Todo log url
        couponTemplateMapper.insertSelective(build);
        //生成code
        CopyOnWriteArrayList<CouponCodeUser> codes = couponUtil.generateCode(couponTemplateParam.getCMerchantId(), couponTemplateParam.getCCount());
        List<CouponCodeUser> collect = codes.stream().map(code ->
        {
            code.setcId(build.getcId());
            code.setcStatus("1");
            return code;
        }).collect(Collectors.toList());
        //插入数据库
        couponCodeUserService.insertRange(collect);
    }
}
