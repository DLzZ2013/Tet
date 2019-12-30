package cn.edu.tetcouponmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponCodeUser {
    private String cCouponCode;

    private String cId;

    private String cUserId;

    private String cStatus;

    public String getcCouponCode() {
        return cCouponCode;
    }

    public void setcCouponCode(String cCouponCode) {
        this.cCouponCode = cCouponCode == null ? null : cCouponCode.trim();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus == null ? null : cStatus.trim();
    }
}