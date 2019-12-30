package cn.edu.tetcouponmanager.entity.param;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:03 2019/12/28
 * @Modified By:
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class CouponTemplateParam {
    private Integer id;

    private String cId;

    private String cCategory;

    private String cExpireType;

    private Integer cExpireDay;

    private Date cCreateTime;

    private String cConsumeStatus;

    private String cMerchantId;

    private String cMerchantName;

    private String cLogo;

    private String cDesc;

    private String cProductLine;

    private String cAreaId;

    private Integer cLimiter;

    private Integer cCount;

    private double cAmount;

    private double cAmountLimit;

    private String cLinkUrl;
    
}
