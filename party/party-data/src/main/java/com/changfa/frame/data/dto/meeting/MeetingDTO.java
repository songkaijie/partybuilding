package com.changfa.frame.data.dto.meeting;

import java.io.Serializable;
import java.util.Date;

public class MeetingDTO implements Serializable {
    private Integer id;
    private Integer companyId;
    private Integer meetingTypeId;
    private String theme;
    private String descri;
    private String mode;
    private Integer initiatorUserId;
    private Date beginTime;
    private Integer sessionLength;
    private String hostUserId;
    private String recorderUserId;
    private String data;
    private String requirement;
    private Integer partyOrganizationId;
    private String isSynchronousLive;
    private String otherSettings;
    private String password;
    private String signQrcode;
    private String releaseTerminalType;
    private String province;
    private String city;
    private String county;
    private String detailAddress;
    private String fullAddress;
    private String status;
    private Date statusTime;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getMeetingTypeId() {
        return meetingTypeId;
    }

    public void setMeetingTypeId(Integer meetingTypeId) {
        this.meetingTypeId = meetingTypeId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getInitiatorUserId() {
        return initiatorUserId;
    }

    public void setInitiatorUserId(Integer initiatorUserId) {
        this.initiatorUserId = initiatorUserId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getSessionLength() {
        return sessionLength;
    }

    public void setSessionLength(Integer sessionLength) {
        this.sessionLength = sessionLength;
    }

    public String getHostUserId() {
        return hostUserId;
    }

    public void setHostUserId(String hostUserId) {
        this.hostUserId = hostUserId;
    }

    public String getRecorderUserId() {
        return recorderUserId;
    }

    public void setRecorderUserId(String recorderUserId) {
        this.recorderUserId = recorderUserId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getPartyOrganizationId() {
        return partyOrganizationId;
    }

    public void setPartyOrganizationId(Integer partyOrganizationId) {
        this.partyOrganizationId = partyOrganizationId;
    }

    public String getIsSynchronousLive() {
        return isSynchronousLive;
    }

    public void setIsSynchronousLive(String isSynchronousLive) {
        this.isSynchronousLive = isSynchronousLive;
    }

    public String getOtherSettings() {
        return otherSettings;
    }

    public void setOtherSettings(String otherSettings) {
        this.otherSettings = otherSettings;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignQrcode() {
        return signQrcode;
    }

    public void setSignQrcode(String signQrcode) {
        this.signQrcode = signQrcode;
    }

    public String getReleaseTerminalType() {
        return releaseTerminalType;
    }

    public void setReleaseTerminalType(String releaseTerminalType) {
        this.releaseTerminalType = releaseTerminalType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
