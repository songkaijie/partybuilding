package com.changfa.frame.zuul.entity;


/**
 * 访问次数限制
 */
public class AccessFrequency {
    //IP标识
    protected String id;
    //服务模块
    protected String serverName;
    //API服务
    protected String apiName;
    //限制次数
    protected String totalTimes;
    //剩余次数
    protected String surplusTimes;
    //预警阈值
    protected String preAlarmThreshold;
    //告警阈值
    protected String alarmThreshold;
    //状态 0 在用 1 注销
    protected String sts;
    //状态时间
    protected String stsDate;
    //创建时间
    protected String createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(String totalTimes) {
        this.totalTimes = totalTimes;
    }

    public String getSurplusTimes() {
        return surplusTimes;
    }

    public void setSurplusTimes(String surplusTimes) {
        this.surplusTimes = surplusTimes;
    }

    public String getPreAlarmThreshold() {
        return preAlarmThreshold;
    }

    public void setPreAlarmThreshold(String preAlarmThreshold) {
        this.preAlarmThreshold = preAlarmThreshold;
    }

    public String getAlarmThreshold() {
        return alarmThreshold;
    }

    public void setAlarmThreshold(String alarmThreshold) {
        this.alarmThreshold = alarmThreshold;
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