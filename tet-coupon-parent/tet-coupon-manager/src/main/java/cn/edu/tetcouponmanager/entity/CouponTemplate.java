package cn.edu.tetcouponmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponTemplate {
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

    private BigDecimal cAmount;

    private BigDecimal cAmountLimit;

    private String cLinkUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcCategory() {
        return cCategory;
    }

    public void setcCategory(String cCategory) {
        this.cCategory = cCategory == null ? null : cCategory.trim();
    }

    public String getcExpireType() {
        return cExpireType;
    }

    public void setcExpireType(String cExpireType) {
        this.cExpireType = cExpireType == null ? null : cExpireType.trim();
    }

    public Integer getcExpireDay() {
        return cExpireDay;
    }

    public void setcExpireDay(Integer cExpireDay) {
        this.cExpireDay = cExpireDay;
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public String getcConsumeStatus() {
        return cConsumeStatus;
    }

    public void setcConsumeStatus(String cConsumeStatus) {
        this.cConsumeStatus = cConsumeStatus == null ? null : cConsumeStatus.trim();
    }

    public String getcMerchantId() {
        return cMerchantId;
    }

    public void setcMerchantId(String cMerchantId) {
        this.cMerchantId = cMerchantId == null ? null : cMerchantId.trim();
    }

    public String getcMerchantName() {
        return cMerchantName;
    }

    public void setcMerchantName(String cMerchantName) {
        this.cMerchantName = cMerchantName == null ? null : cMerchantName.trim();
    }

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo == null ? null : cLogo.trim();
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc == null ? null : cDesc.trim();
    }

    public String getcProductLine() {
        return cProductLine;
    }

    public void setcProductLine(String cProductLine) {
        this.cProductLine = cProductLine == null ? null : cProductLine.trim();
    }

    public String getcAreaId() {
        return cAreaId;
    }

    public void setcAreaId(String cAreaId) {
        this.cAreaId = cAreaId == null ? null : cAreaId.trim();
    }

    public Integer getcLimiter() {
        return cLimiter;
    }

    public void setcLimiter(Integer cLimiter) {
        this.cLimiter = cLimiter;
    }

    public Integer getcCount() {
        return cCount;
    }

    public void setcCount(Integer cCount) {
        this.cCount = cCount;
    }


}