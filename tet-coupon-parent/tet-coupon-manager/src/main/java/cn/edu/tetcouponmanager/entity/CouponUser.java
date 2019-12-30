package cn.edu.tetcouponmanager.entity;

import java.util.Date;

public class CouponUser extends CouponUserKey {
    private Integer cCount;

    private Date cGetTime;

    private Integer cExpireDay;

    public Integer getcCount() {
        return cCount;
    }

    public void setcCount(Integer cCount) {
        this.cCount = cCount;
    }

    public Date getcGetTime() {
        return cGetTime;
    }

    public void setcGetTime(Date cGetTime) {
        this.cGetTime = cGetTime;
    }

    public Integer getcExpireDay() {
        return cExpireDay;
    }

    public void setcExpireDay(Integer cExpireDay) {
        this.cExpireDay = cExpireDay;
    }
}