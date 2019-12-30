package cn.edu.tetcouponmanager.controller;

import cn.edu.global.common.ResultResponse;
import cn.edu.tetcouponmanager.controller.util.BindingResultUtil;
import cn.edu.tetcouponmanager.entity.param.CouponTemplateParam;
import cn.edu.tetcouponmanager.service.CouponTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 16:22 2019/12/27
 * @Modified By:
 */
@RestController
@Api("优惠券模板接口")
public class CouponTemplateController {
    @Autowired
    private CouponTemplateService couponTemplateService;
    @ApiOperation("新增优惠券模板")
    @PostMapping("couponTemplate")
    @ResponseBody
    public ResultResponse insert(@ApiParam("模板接收实体类")@Validated @RequestBody CouponTemplateParam couponTemplateParam, BindingResult bindingResult) {
        //检查参数
        BindingResultUtil.checkResult(bindingResult);
        couponTemplateService.insert(couponTemplateParam);
        return ResultResponse.success();
    }
}
