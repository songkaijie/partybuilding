package com.changfa.frame.zuul.entity;


/**
 * 时间对于表
 */
public class RestrictionMode {
    //限制表id
    protected String restrictionId;
    //限制时间模式
    protected String timeModel;
    //开始时间
    protected String startTime;
    //结束时间
    protected String endTime;
    //小时
    protected String restrictionHour;
    //天
    protected String restrictionDay;
    //星期
    protected String restrictionWeek;
    //月份
    protected String restrictionMonth;
    //状态
    protected String sts;
    //状态时间
    protected String stsDate;
    //创建时间
    protected String createDate;

    public String getRestrictionId() {
        return restrictionId;
    }

    public void setRestrictionId(String restrictionId) {
        this.restrictionId = restrictionId;
    }

    public String getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(String timeModel) {
        this.timeModel = timeModel;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRestrictionHour() {
        return restrictionHour;
    }

    public void setRestrictionHour(String restrictionHour) {
        this.restrictionHour = restrictionHour;
    }

    public String getRestrictionDay() {
        return restrictionDay;
    }

    public void setRestrictionDay(String restrictionDay) {
        this.restrictionDay = restrictionDay;
    }

    public String getRestrictionWeek() {
        return restrictionWeek;
    }

    public void setRestrictionWeek(String restrictionWeek) {
        this.restrictionWeek = restrictionWeek;
    }

    public String getRestrictionMonth() {
        return restrictionMonth;
    }

    public void setRestrictionMonth(String restrictionMonth) {
        this.restrictionMonth = restrictionMonth;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getStsDate() {
        return stsDate;
    }

    public void setStsDate(String stsDate) {
        this.stsDate = stsDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}